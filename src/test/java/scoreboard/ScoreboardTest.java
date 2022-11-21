package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreboardTest {

    public static final String HOME_TEAM = "England";
    public static final String AWAY_TEAM = "Spain";

    @Test
    void whenStartGameThenReturnGame() {
        var scoreboard = new Scoreboard();

        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        assertEquals(HOME_TEAM, game.getHomeTeam());
        assertEquals(AWAY_TEAM, game.getAwayTeam());
    }

}