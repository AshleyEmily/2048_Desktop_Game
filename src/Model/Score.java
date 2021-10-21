package Model;

public class Score {
    private int score;
    private static int highScore;

    /**
     * Default constructor for Score class
     */
    public Score()
    {
        score = 0;
        highScore = 0;
    }

    public void updateScore(int scoreValue)
    {
        score = scoreValue;
    }

    public void updateHighScore(int newScore)
    {
        highScore = newScore;
    }

    public int getScore()
    {
        return score;
    }

    public int getHighScore()
    {
        return highScore;
    }
}