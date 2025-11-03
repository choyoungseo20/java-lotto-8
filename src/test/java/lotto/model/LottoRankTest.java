package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("로또 번호가 6개 일치하면 1등을 반환한다.")
    @Test
    void 로또_번호가_6개_일치하면_1등을_반환한다() {
        assertThat(LottoRank.of(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("로또 번호가 5개 일치하고 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void 로또_번호가_5개_일치하고_보너스_번호가_일치하면_2등을_반환한다() {
        assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 번호가 5개 일치하면 3등을 반환한다.")
    @Test
    void 로또_번호가_5개_일치하면_3등을_반환한다() {
        assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("로또 번호가 4개 일치하면 4등을 반환한다.")
    @Test
    void 로또_번호가_4개_일치하면_4등을_반환한다() {
        assertThat(LottoRank.of(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("로또 번호가 3개 일치하면 5등을 반환한다.")
    @Test
    void 로또_번호가_3개_일치하면_5등을_반환한다() {
        assertThat(LottoRank.of(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("1등의 당첨 금액을 확인한다.")
    @Test
    void 등수별_당첨_금액을_확인한다_1등() {
        assertThat(LottoRank.FIRST.getMatchCount()).isEqualTo(6);
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("2등의 당첨 금액을 확인한다.")
    @Test
    void 등수별_당첨_금액을_확인한다_2등() {
        assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("3등의 당첨 금액을 확인한다.")
    @Test
    void 등수별_당첨_금액을_확인한다_3등() {
        assertThat(LottoRank.THIRD.getMatchCount()).isEqualTo(5);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1_500_000);
    }

    @DisplayName("4등의 당첨 금액을 확인한다.")
    @Test
    void 등수별_당첨_금액을_확인한다_4등() {
        assertThat(LottoRank.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50_000);
    }

    @DisplayName("5등의 당첨 금액을 확인한다.")
    @Test
    void 등수별_당첨_금액을_확인한다_5등() {
        assertThat(LottoRank.FIFTH.getMatchCount()).isEqualTo(3);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5_000);
    }
}
