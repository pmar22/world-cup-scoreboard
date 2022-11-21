package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}