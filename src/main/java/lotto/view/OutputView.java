package lotto.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningResult;

public class OutputView {

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "{0}개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 {0}%입니다.";
    private static final String WINNING_FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - {0}개";
    private static final String WINNING_FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - {0}개";
    private static final String WINNING_THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - {0}개";
    private static final String WINNING_SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - {0}개";
    private static final String WINNING_FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - {0}개";

    public void printPurchasedLottos(List<Lotto> lottos) {
        printPurchasedLottoCount(lottos.size());
        lottos.forEach(this::printLotto);
    }

    public void printResult(WinningResult winningResult, double rateOfReturn) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        printRankDetail(winningResult);
        printRateOfReturn(rateOfReturn);
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

    private void printRankDetail(WinningResult winningResult) {
        System.out.println(MessageFormat.format(
                WINNING_FIFTH_RANK_MESSAGE, winningResult.getCountByRank(LottoRank.FIFTH)));
        System.out.println(MessageFormat.format(
                WINNING_FOURTH_RANK_MESSAGE, winningResult.getCountByRank(LottoRank.FOURTH)));
        System.out.println(MessageFormat.format(
                WINNING_THIRD_RANK_MESSAGE, winningResult.getCountByRank(LottoRank.THIRD)));
        System.out.println(MessageFormat.format(
                WINNING_SECOND_RANK_MESSAGE, winningResult.getCountByRank(LottoRank.SECOND)));
        System.out.println(MessageFormat.format(
                WINNING_FIRST_RANK_MESSAGE, winningResult.getCountByRank(LottoRank.FIRST)));
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.println(MessageFormat.format(RATE_OF_RETURN_MESSAGE, String.format("%.1f", rateOfReturn)));
    }
}
