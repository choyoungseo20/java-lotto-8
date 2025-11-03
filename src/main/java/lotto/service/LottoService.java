package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.generator.NumberGenerator;
import lotto.model.generator.UniqueRandomNumberGenerator;

public class LottoService {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    public List<Lotto> createLottos(PurchaseAmount purchaseAmount) {
        Integer purchaseCount = purchaseAmount.getPurchaseCount();
        List<Lotto> lottos = new ArrayList<>(purchaseCount);

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        NumberGenerator lottoGenerator = new UniqueRandomNumberGenerator(LOWER_BOUND, UPPER_BOUND);
        List<Integer> lottoNumbers = lottoGenerator.generateNumbers(COUNT);
        return new Lotto(lottoNumbers);
    }
}
