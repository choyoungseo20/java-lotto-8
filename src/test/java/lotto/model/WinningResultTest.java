package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();

        LottoRank lottoRank1 = LottoRank.of(5, false);
        LottoRank lottoRank2 = LottoRank.of(5, true);
        LottoRank lottoRank3 = LottoRank.of(5, false);

        winningResult.put(lottoRank1);
        winningResult.put(lottoRank2);
        winningResult.put(lottoRank3);
    }

    @DisplayName("당첨 개수가 맞는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST, 0",
            "SECOND, 1",
            "THIRD, 2",
            "FOURTH, 0",
            "FIFTH, 0",
            "NONE, 0"
    })
    void 당첨_개수가_맞는지_확인한다(LottoRank lottoRank, int expected) {
        assertThat(winningResult.getCountByRank(lottoRank)).isEqualTo(expected);
    }

    @DisplayName("총 당첨 금액이 맞는지 확인한다.")
    @Test
    void 총_당첨_금액이_맞는지_확인한다() {
        assertThat(winningResult.calculateTotalPrize()).isEqualTo(33_000_000);
    }
}
