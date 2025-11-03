package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("로또 등수 계산을 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE",
            "1, false, NONE",
            "0, false, NONE"
    })
    void 로또_등수_계산을_확인한다(int matchCount, boolean hasBonusNumber, LottoRank expected) {
        assertThat(LottoRank.of(matchCount, hasBonusNumber)).isEqualTo(expected);
    }

    @DisplayName("등수별 당첨 금액을 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "FIRST, 2_000_000_000",
            "SECOND, 30_000_000",
            "THIRD, 1_500_000",
            "FOURTH, 50_000",
            "FIFTH, 5_000",
            "NONE, 0"
    })
    void 등수별_당첨_금액을_확인한다(LottoRank lottoRank, int expected) {
        assertThat(lottoRank.getPrize()).isEqualTo(expected);
    }

    @DisplayName("등수별 당첨 개수를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST, 6",
            "SECOND, 5",
            "THIRD, 5",
            "FOURTH, 4",
            "FIFTH, 3",
            "NONE, 0"
    })
    void 등수별_당첨_개수를_확인한다(LottoRank lottoRank, int expected) {
        assertThat(lottoRank.getMatchCount()).isEqualTo(expected);
    }
}
