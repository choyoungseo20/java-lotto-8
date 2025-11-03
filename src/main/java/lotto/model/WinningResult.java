package lotto.model;


import java.util.HashMap;
import java.util.Map;

public class WinningResult {

    private final Map<LottoRank, Integer> rankCount = new HashMap<>();

    public void put(LottoRank rank) {
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCount;
    }

    public Integer getCountByRank(LottoRank lottoRank) {
        return rankCount.getOrDefault(lottoRank, 0);
    }

    public long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
