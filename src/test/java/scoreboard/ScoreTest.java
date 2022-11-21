package scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreTest {

    @Test
    void whenNewScoreThenReturnScore() {
        var homeTeamGoals = 3;
        var awayTeamGoals = 4;

        var score = new Score(homeTeamGoals, awayTeamGoals);

        assertEquals(homeTeamGoals, score.getHomeTeamGoals());
        assertEquals(awayTeamGoals, score.getAwayTeamGoals());
    }
}