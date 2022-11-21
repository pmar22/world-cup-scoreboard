package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(0, game.getHomeTeamGoals());
        assertEquals(0, game.getAwayTeamGoals());
    }
}