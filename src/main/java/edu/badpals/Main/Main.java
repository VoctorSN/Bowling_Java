package edu.badpals.Main;
import edu.badpals.Bowling.Frame;
import edu.badpals.Bowling.ScoreCard;

public class Main {
    static Frame frame = null;
    public static void main(String[] args){
        ScoreCard scoreCard = new ScoreCard("5/5/5/5/5/5/5/5/5/5/5");
        System.out.println(scoreCard.getPins());
    }
}
