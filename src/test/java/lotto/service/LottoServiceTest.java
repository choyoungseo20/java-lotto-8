package lotto.service;

import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @DisplayName("구입 금액에 맞춰 로또가 발행되는지 확인한다.")
    @Test
    void 구입_금액에_맞춰_로또가_발행되는지_확인한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);

        assertThat(lottos).hasSize(5);
    }

    @DisplayName("당첨 결과를 정확히 생성하는지 확인한다.")
    @Test
    void 당첨_결과를_정확히_생성하는지_확인한다() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<Lotto> purchasedLottos = List.of(lotto1, lotto2, lotto3);

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        WinningResult result = lottoService.checkWinning(purchasedLottos, winningLotto);

        assertThat(result.getCountByRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getCountByRank(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCountByRank(LottoRank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("수익률을 정확히 계산하는지 확인한다.")
    @Test
    void 수익률을_정확히_계산하는지_확인한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);

        WinningResult winningResult = new WinningResult();
        winningResult.put(LottoRank.FIRST);

        double rateOfReturn = lottoService.calculateRateOfReturn(purchaseAmount, winningResult);

        assertThat(rateOfReturn).isEqualTo(40_000_000.0);
    }
}
