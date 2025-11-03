package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
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

    public WinningResult checkWinning(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto lotto : purchasedLottos) {
            LottoRank lottoRank = checkLottoRank(lotto, winningLotto);
            winningResult.put(lottoRank);
        }

        return winningResult;
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount, WinningResult winningResult) {
        Integer totalPrize = winningResult.calculateTotalPrize();
        double rateOfReturn = (double) totalPrize / purchaseAmount.getValue() * 100;
        return Math.round(rateOfReturn * 10) / 10.0;
    }

    private Lotto createLotto() {
        NumberGenerator lottoGenerator = new UniqueRandomNumberGenerator(LOWER_BOUND, UPPER_BOUND);
        List<Integer> lottoNumbers = lottoGenerator.generateNumbers(COUNT);
        return new Lotto(lottoNumbers);
    }

    private LottoRank checkLottoRank(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> winningMainNumbers = winningLotto.getMain().getNumbers();
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningMainNumbers::contains)
                .count();

        boolean hasBonusNumber = lotto.getNumbers().contains(winningLotto.getBonusNumber());

        return LottoRank.of(matchCount, hasBonusNumber);
    }
}
