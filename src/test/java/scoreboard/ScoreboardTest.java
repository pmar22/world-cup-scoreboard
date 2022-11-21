package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {

    @Test
    void whenStartGameThenReturnGame() {
        var homeTeam = "England";
        var awayTeam = "Spain";
        var scoreboard = new Scoreboard();

        var game = scoreboard.startGame(homeTeam, awayTeam);

        assertEquals(homeTeam, game.getHomeTeam());
        assertEquals(awayTeam, game.getAwayTeam());
    }

}