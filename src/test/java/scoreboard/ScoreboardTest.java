package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreboardTest {

    private static final String HOME_TEAM = "England";
    private static final String AWAY_TEAM = "Spain";

    @Test
    void whenStartGameThenReturnGame() {
        var scoreboard = new Scoreboard();

        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);

        assertEquals(HOME_TEAM, game.getHomeTeam());
        assertEquals(AWAY_TEAM, game.getAwayTeam());
    }

    @Test
    void whenUpdateScoreThenReturnUpdatedGame() {
        var scoreboard = new Scoreboard();
        var game = scoreboard.startGame(HOME_TEAM, AWAY_TEAM);
        var homeTeamGoals = 2;
        var awayTeamGoals = 1;
        var score = new Score(homeTeamGoals, awayTeamGoals);

        Game updatedGame = scoreboard.updateScore(game, score);

        var updatedScore = updatedGame.getScore();
        assertEquals(homeTeamGoals, updatedScore.getHomeTeamGoals());
        assertEquals(awayTeamGoals, updatedScore.getAwayTeamGoals());
        assertEquals(HOME_TEAM, updatedGame.getHomeTeam());
        assertEquals(AWAY_TEAM, updatedGame.getAwayTeam());
    }

}