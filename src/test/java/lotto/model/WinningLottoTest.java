package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("로또 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        Lotto main = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(main, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작을 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_1보다_작을_경우_예외가_발생한다() {
        Lotto main = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 0;

        assertThatThrownBy(() -> new WinningLotto(main, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 클 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_45보다_클_경우_예외가_발생한다() {
        Lotto main = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 46;

        assertThatThrownBy(() -> new WinningLotto(main, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
