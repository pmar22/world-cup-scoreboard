package scoreboard.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreTest {

    @Test
    void whenNewScoreThenReturnScore() {
        var homeTeamGoals = 3;
        var awayTeamGoals = 4;

        var score = new Score(homeTeamGoals, awayTeamGoals);

        assertEquals(homeTeamGoals, score.getHome());
        assertEquals(awayTeamGoals, score.getAway());
    }

    @Test
    void whenHomeScoreBelowZeroThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Score(-1, 0));
    }

    @Test
    void whenAwayScoreBelowZeroThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Score(0, -1));
    }

    @Test
    void whenEqualsThenKeepContract() {
        EqualsVerifier.forClass(Score.class).verify();
    }
}