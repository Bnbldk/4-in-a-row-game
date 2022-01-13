package p2021.game4inarow;

/**
 *
 * @author Bruno Borges
 */
//inheritance Score extends Player
public class Score {
    // attributers

    private static int pScore;
    private static int cScore;
    private static int draw;

    Score() { // constructor
        pScore = 0;
        cScore = 0;
        draw = 0;
    }

      //getters and setters
    public static void setpScore(int pScore) {
        Score.pScore = pScore;
    }

    public static void setcScore(int cScore) {
        Score.cScore = cScore;
    }

    public static void setDraw(int draw) {
        Score.draw = draw;
    }

    public static int getpScore() {
        return pScore;
    }

    public static int getcScore() {
        return cScore;
    }

    public static int getDraw() {
        return draw;
    }

//store the scores and print on console
    public static int checkScore(int score) { // integer parameter
        //switch statement for print the winner of the match and if it is a draw
        
        switch (score) { 
            case 0 -> {
                System.out.println("Player WINS");
                pScore++;
                setpScore(pScore);
                
            }
            case 1 -> {
                System.out.println("Computer WINS");
                cScore++;
                setcScore(cScore);
            }
            case 2 -> {
                System.out.println("it is a Draw");
                draw++;
                setDraw(draw);
            }
            default ->
                System.out.println("");
        }

        return draw + cScore + pScore; // return the sum of all scores
    }

    //print scores in console
    @Override
    public String toString() {
        return "Scores {Player=" + getpScore() + ", Computer=" + getcScore() + ", Draws=" + getDraw() + "}";

    }

}
