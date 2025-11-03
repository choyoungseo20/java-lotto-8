package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "\\d+";
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_MAIN_WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_WINNING_LOTTO_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    public Integer readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        String input = readInput();
        return parseIntWithValidation(input);
    }

    public List<Integer> readMainWinningLottoNumbers() {
        System.out.println();
        System.out.println(READ_MAIN_WINNING_LOTTO_NUMBERS_MESSAGE);
        String input = readInput();
        return parseMainWinningLottoNumbers(input);
    }

    public Integer readBonusWinningLottoNumber() {
        System.out.println();
        System.out.println(READ_BONUS_WINNING_LOTTO_NUMBER_MESSAGE);
        String input = readInput();
        return parseIntWithValidation(input);
    }

    private String readInput() {
        return Console.readLine();
    }

    private List<Integer> parseMainWinningLottoNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(this::parseIntWithValidation).toList();
    }

    private Integer parseIntWithValidation(String input) {
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
