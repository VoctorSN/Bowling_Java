package edu.badpals.Bowling;
import java.util.ArrayList;

public class ScoreCard {
    private final int INITIAL_SCORE = 0;
    public int game_score;
    public String game;

    public ScoreCard(String game) {
        this.game_score = this.INITIAL_SCORE;
        this.game = game;
    }
    public ArrayList<String> getPins(){
        return this.stylizer();
    }
    public int calculateScore(){
        ArrayList<String> game = this.stylizer();
        for (int position = 0; position < 10; position++){
            String frame = game.get(position);
            Frame it = new Frame(frame);
            if (it.is_strike()){
                this.calculateStrike(game,frame,position);
            }
            else if (it.is_spare()){
                this.calculateSpare(game,frame,position);
            }
            else {
                this.game_score += it.calculate_frame_puntuation();
            }
        }
        return this.game_score;
    }
    private ArrayList<String> stylizer(){
        ArrayList<String> pins = new ArrayList<>();
        String game = this.game.replace("X","XX");
        if (game.length() == 21){
            game += "-";
        }
        for (int position = 1; position < game.length(); position+=2){
            char roll = game.charAt(position);
            String rolls = "" + game.charAt(position);
            boolean isStrike = new Frame(null).is_strike(roll);
            if (isStrike){
                pins.add(rolls);
                continue;
            }
            String frame = "" + game.charAt(position-1) + roll;
            pins.add(frame);
        }
        return pins;
    }

    private void calculateStrike(ArrayList<String> game, String frame, int position){
        this.calculateSpare(game,frame,position);
        String nextFrame = game.get(position+1);
        boolean isSpear = new Frame(nextFrame).is_spare();
        boolean isStrike = new Frame(nextFrame).is_strike();
        if (isStrike){
            char second_next_pin = game.get(position+2).charAt(0);
            this.game_score += new Frame().getScoreByPin(second_next_pin);
            return;
        }
        char second_roll = game.get(position+1).charAt(1);
        this.game_score += new Frame().getScoreByPin(second_roll);
        if (isSpear){
            char next_roll = game.get(position+1).charAt(0);
            this.game_score -= new Frame().getScoreByPin(next_roll);
        }
    }

    private void calculateSpare(ArrayList<String> game, String frame, int position){
        frame = game.get(position-1);
        String next_roll = "" + frame.charAt(0);
        int roll_puntuation = new Frame(frame).calculate_frame_puntuation();
        int next_roll_puntuation = new Frame(next_roll).calculate_frame_puntuation();
        this.game_score += roll_puntuation + next_roll_puntuation;
    }
}