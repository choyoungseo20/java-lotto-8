package lotto.service;

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
}
