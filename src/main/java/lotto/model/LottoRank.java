package lotto.model;

import java.util.Map;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final Map<Integer, LottoRank> LOTTO_RANKS = Map.of(
            3, FIFTH,
            4, FOURTH,
            5, THIRD,
            6, FIRST
    );

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 5 && hasBonusNumber) {
            return SECOND;
        }
        return LOTTO_RANKS.getOrDefault(matchCount, NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
