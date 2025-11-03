package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원보다 작을 경우 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원보다_작을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
