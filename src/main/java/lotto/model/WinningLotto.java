package lotto.model;

public class WinningLotto {

    private final Lotto main;
    private final Integer bonusNumber;

    public WinningLotto(Lotto main, Integer bonusNumber) {
        this.main = main;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getMain() {
        return main;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
