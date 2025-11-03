package lotto.model.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class UniqueRandomNumberGenerator implements NumberGenerator {

    private final int lowerBound;
    private final int upperBound;

    public UniqueRandomNumberGenerator(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public List<Integer> generateNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(lowerBound, upperBound, count);
    }
}
