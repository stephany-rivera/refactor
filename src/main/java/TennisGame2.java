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

    public String getScore() {
        String score = "";
        if (player1Point == player2Point && player1Point < 3) {
            score = pointWhenDraw(player1Point);
        }

        if (player1Point > 0 && player2Point ==0)
        {
            if (player1Point ==1)
                player1Score = "Fifteen";
            if (player1Point ==2)
                player1Score = "Thirty";
            if (player1Point ==3)
                player1Score = "Forty";
            
            player2Score = "Love";
            score = player1Score + "-" + player2Score;
        }

        if (player2Point > 0 && player1Point ==0)
        {
            if (player2Point ==1)
                player2Score = "Fifteen";
            if (player2Point ==2)
                player2Score = "Thirty";
            if (player2Point ==3)
                player2Score = "Forty";
            
            player1Score = "Love";
            score = player1Score + "-" + player2Score;
        }
        
        if (player1Point > player2Point && player1Point < 4)
        {
            if (player1Point ==2)
                player1Score ="Thirty";
            if (player1Point ==3)
                player1Score ="Forty";
            if (player2Point ==1)
                player2Score ="Fifteen";
            if (player2Point ==2)
                player2Score ="Thirty";
            score = player1Score + "-" + player2Score;
        }
        if (player2Point > player1Point && player2Point < 4)
        {
            if (player2Point ==2)
                player2Score ="Thirty";
            if (player2Point ==3)
                player2Score ="Forty";
            if (player1Point ==1)
                player1Score ="Fifteen";
            if (player1Point ==2)
                player1Score ="Thirty";
            score = player1Score + "-" + player2Score;
        }
        
        if (player1Point > player2Point && player2Point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Point > player1Point && player1Point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Point >=4 && player2Point >=0 && (player1Point - player2Point)>=2)
        {
            score = "Win for player1";
        }
        if (player2Point >=4 && player1Point >=0 && (player2Point - player1Point)>=2)
        {
            score = "Win for player2";
        }
        return score;
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