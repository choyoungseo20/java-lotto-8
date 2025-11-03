package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NUMBER_REGEX = "\\d+";
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    public Integer readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        String input = readInput();
        return parseIntWithValidation(input);
    }

    private String readInput() {
        return Console.readLine();
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
