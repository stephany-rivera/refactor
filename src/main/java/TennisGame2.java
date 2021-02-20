import java.util.HashMap;

public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    public String player1Score = "";
    public String player2Score = "";
    private String player1Name;
    private String player2Name;
    private static final HashMap<Integer,String> SCORES= new HashMap<Integer,String>();

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    static{
        SCORES.put(0,"Love");
        SCORES.put(1,"Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    private String getListScores(Integer points){
        return SCORES.get(points);
    }

    private String pointWhenDraw(Integer player1Point){
        if (player1Point<3){
            return SCORES.get(player1Point)+ "-All";
        }
        return "Deuce";
    }

    private String pointsMatch() {
        player1Score = getListScores(player1Point);
        player2Score = getListScores(player2Point);
        return player1Score + "-" + player2Score;
    }

    private String advantage(){
        if(player1Point>player2Point){
            return "Advantage " + this.player1Name;
        }
        return "Advantage " + this.player2Name;
    }

    private String playerWin(Integer player1Point, Integer player2Point){
        if (player1Point > player2Point) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;
    }


    public String getScore() {
        String score = "";
        if (player1Point == player2Point) {
            return pointWhenDraw(player1Point);
        }

        if (player1Point >= 3 && player2Point >= 3) {
            if (Math.abs(player1Point - player2Point) == 1)
                return advantage();
        }

        if (player1Point >= 4 || player2Point >= 4) {
            if (Math.abs(player1Point - player2Point) == 1)
                return playerWin(player1Point, player2Point);
        }

        return pointsMatch();
    }



    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Point++;
    }
    
    public void P2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}