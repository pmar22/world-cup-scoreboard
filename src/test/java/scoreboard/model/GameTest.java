package scoreboard.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    private final String homeTeam = "Poland";
    private final String awayTeam = "Germany";

    @Test
    void whenNewGameThenCreateWithTeamsNames() {
        var game = new Game(homeTeam, awayTeam);

        assertEquals(homeTeam, game.getHomeTeam());
        assertEquals(awayTeam, game.getAwayTeam());
    }

    @Test
    void whenNewGameThenCreateWithInitialScore() {
        var game = new Game(homeTeam, awayTeam);

        var score = game.getScore();
        assertEquals(0, score.getHome());
        assertEquals(0, score.getAway());
    }

    @Test
    void whenNewGameWithNullScoreThenThrowException() {
        assertThrows(NullPointerException.class, () -> new Game(homeTeam, awayTeam, LocalDateTime.now(), null));
    }

    @Test
    void whenNewGameWithNullStartDateThenThrowException() {
        assertThrows(NullPointerException.class, () -> new Game(homeTeam, awayTeam, null, new Score(1,1)));
    }

    @Test
    void whenEqualsThenKeepContract() {
        EqualsVerifier.forClass(Game.class).verify();
    }
}