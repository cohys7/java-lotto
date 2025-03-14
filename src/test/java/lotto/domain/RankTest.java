package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    public static Stream<Arguments> provideCountAndRank() {
        return Stream.of(
                Arguments.of(0, Rank.NON_MATCH),
                Arguments.of(1, Rank.NON_MATCH),
                Arguments.of(2, Rank.NON_MATCH),
                Arguments.of(3, Rank.FORTH),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(6, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCountAndRank")
    void match_rank_by_count(int count, Rank rank) {
        assertThat(Rank.match(count)).isEqualTo(rank);
    }

    @Test
    void calculate_prize() {
        assertThat(Rank.SECOND.calculatePrize(2)).isEqualTo(Rank.SECOND.getPrize() * 2);
    }
}
