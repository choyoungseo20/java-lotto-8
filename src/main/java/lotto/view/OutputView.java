package lotto.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "{0}개를 구매했습니다.";

    public void printPurchasedLottos(List<Lotto> lottos) {
        printPurchasedLottoCount(lottos.size());
        lottos.forEach(this::printLotto);
    }

    private void printPurchasedLottoCount(Integer count) {
        System.out.println();
        System.out.println(MessageFormat.format(PURCHASED_LOTTO_COUNT_MESSAGE, count));
    }

    private void printLotto(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }
}
