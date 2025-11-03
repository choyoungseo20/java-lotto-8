package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.generator.NumberGenerator;
import lotto.model.generator.UniqueRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UniqueRandomNumberGeneratorTest {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    @DisplayName("랜덤 숫자가 범위 안에 있는지 확인한다.")
    @Test
    void 랜덤_숫자가_범위_안에_있는지_확인한다() {
        NumberGenerator generator = new UniqueRandomNumberGenerator(LOWER_BOUND, UPPER_BOUND);

        List<Integer> numbers = generator.generateNumbers(COUNT);

        for (int number : numbers) {
            assertThat(number).isBetween(LOWER_BOUND, UPPER_BOUND);
        }
    }

    @DisplayName("랜덤 숫자의 개수가 일치하는지 확인한다.")
    @Test
    void 랜덤_숫자의_개수가_일치하는지_확인한다() {
        NumberGenerator generator = new UniqueRandomNumberGenerator(LOWER_BOUND, UPPER_BOUND);

        List<Integer> numbers = generator.generateNumbers(COUNT);

        assertThat(numbers.size()).isEqualTo(COUNT);
    }

    @DisplayName("랜덤 숫자에 중복이 없는지 확인한다.")
    @Test
    void 랜덤_숫자에_중복이_없는지_확인한다() {
        NumberGenerator generator = new UniqueRandomNumberGenerator(LOWER_BOUND, UPPER_BOUND);

        List<Integer> numbers = generator.generateNumbers(COUNT);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertThat(uniqueNumbers.size()).isEqualTo(COUNT);
    }
}
