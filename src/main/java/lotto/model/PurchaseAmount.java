package lotto.model;

public class PurchaseAmount {

    private static final String  PURCHASE_AMOUNT_INVALID_UNIT_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해주세요.";

    private final Integer value;

    public PurchaseAmount(Integer value) {
        validate(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validate(Integer value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INVALID_UNIT_ERROR_MESSAGE);
        }
    }
}
