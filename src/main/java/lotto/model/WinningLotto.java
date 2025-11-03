package lotto.model;

public class WinningLotto {

    private static final String DUPLICATE_WINNING_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 당첨 번호는 중복될 수 없습니다.";
    private static final String WINNING_LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final Lotto main;
    private final Integer bonusNumber;

    public WinningLotto(Lotto main, Integer bonusNumber) {
        this.main = main;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getMain() {
        return main;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Integer number) {
        if (isDuplicate(number)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_LOTTO_NUMBER_ERROR_MESSAGE);
        }
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(WINNING_LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicate(Integer number) {
        return main.getNumbers().contains(number);
    }

    private boolean isOutOfRange(Integer number) {
        return number < 1 || number > 45;
    }
}
