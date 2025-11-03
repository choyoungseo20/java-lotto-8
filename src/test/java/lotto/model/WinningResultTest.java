package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨 개수가 맞는지 확인한다.")
    @Test
    void 당첨_개수가_맞는지_확인한다() {
        WinningResult winningResult = new WinningResult();

        LottoRank lottoRank1 = LottoRank.of(5, false);
        LottoRank lottoRank2 = LottoRank.of(5, true);
        LottoRank lottoRank3 = LottoRank.of(5, false);

        winningResult.put(lottoRank1);
        winningResult.put(lottoRank2);
        winningResult.put(lottoRank3);

        assertThat(winningResult.getCountByRank(LottoRank.FIRST)).isEqualTo(0);
        assertThat(winningResult.getCountByRank(LottoRank.SECOND)).isEqualTo(1);
        assertThat(winningResult.getCountByRank(LottoRank.THIRD)).isEqualTo(2);
    }

    @DisplayName("총 당첨 금액이 맞는지 확인한다.")
    @Test
    void 총_당첨_금액이_맞는지_확인한다() {
        WinningResult winningResult = new WinningResult();

        LottoRank lottoRank1 = LottoRank.of(5, false);
        LottoRank lottoRank2 = LottoRank.of(5, true);
        LottoRank lottoRank3 = LottoRank.of(5, false);

        winningResult.put(lottoRank1);
        winningResult.put(lottoRank2);
        winningResult.put(lottoRank3);

        assertThat(winningResult.calculateTotalPrize()).isEqualTo(33_000_000);
    }
}
