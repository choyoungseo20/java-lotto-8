package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.size() != uniqueNumbers.size();
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < 1 || number > 45);
    }
}
