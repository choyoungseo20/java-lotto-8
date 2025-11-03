package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("구입 금액에 따른 구입 개수가 맞는지 확인한다.")
    @Test
    void 구입_금액에_따른_구입_개수가_맞는지_확인한다() {
        PurchaseAmount purchaseAmount =  new PurchaseAmount(10000);
        assertThat(purchaseAmount.getPurchaseCount()).isEqualTo(10);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원보다 작을 경우 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원보다_작을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
