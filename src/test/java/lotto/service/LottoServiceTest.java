package lotto.service;

import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();
    private List<Lotto> purchasedLottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        purchasedLottos = List.of(lotto1, lotto2, lotto3);
        winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
    }

    @DisplayName("구입 금액에 맞춰 로또가 발행되는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1000, 1",
            "10000, 10",
            "100000, 100",
            "1000000, 1000",
            "10000000, 10000"
    })
    void 구입_금액에_맞춰_로또가_발행되는지_확인한다(int purchaseAmountValue, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountValue);
        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);

        assertThat(lottos).hasSize(expected);
    }

    @DisplayName("당첨 결과를 정확히 생성하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST, 1",
            "SECOND, 1",
            "THIRD, 0",
            "FOURTH, 1",
            "FIFTH, 0",
            "NONE, 0"
    })
    void 당첨_결과를_정확히_생성하는지_확인한다(LottoRank lottoRank, int expected) {
        WinningResult result = lottoService.checkWinning(purchasedLottos, winningLotto);

        assertThat(result.getCountByRank(lottoRank)).isEqualTo(expected);
    }

    @DisplayName("수익률을 정확히 계산하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1000, 203_005_000.0",
            "2000, 101_502_500.0",
            "3000, 67_668_333.3",
            "4000, 50_751_250.0",
            "5000, 40_601_000.0",
    })
    void 수익률을_정확히_계산하는지_확인한다(int purchaseAmountValue, double expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountValue);

        WinningResult winningResult = lottoService.checkWinning(purchasedLottos, winningLotto);

        double rateOfReturn = lottoService.calculateRateOfReturn(purchaseAmount, winningResult);

        assertThat(rateOfReturn).isEqualTo(expected);
    }
}
