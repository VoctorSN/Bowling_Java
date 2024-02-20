package edu.badpals.Bowling;

public class Frame {
    private String frame;
    private final int MAX_PIN_PUNTUATION = 10;
    private final int ZERO = 0;
    public Frame() {
        this.frame = "";
    }

    public Frame(String scoreCard) {
        this.frame = scoreCard;
    }
    public int getScoreByPin(char pin) {
        int Score = ZERO;
        if (pin == '/' || pin == 'X'){
            Score = MAX_PIN_PUNTUATION;
        } else if (pin != '-'){
            Score = Character.getNumericValue(pin);
        }
        return Score;
    }
    public int calculate_frame_puntuation(){
        frame = this.frame;
        char first_roll = frame.charAt(0);
        if (is_strike(first_roll)){
            return getScoreByPin(first_roll);
        }
        char second_roll = frame.charAt(1);
        if (is_spare(second_roll)){
            return getScoreByPin(second_roll);
        }
        return getScoreByPin(first_roll) + getScoreByPin(second_roll);
    }
    public boolean is_spare(){
        frame = this.frame;
        if (frame.length() == 1){
            return false;
        }
        return frame.charAt(1) == '/';
    }

    public boolean is_spare(char pin) {
        return pin == '/';
    }

    public boolean is_strike(){
        frame = this.frame;
        return frame.equals("X");
    }

    public boolean is_strike(char pin) {
        return pin == 'X';
    }

    public String getFrame(){
        return this.frame;
    }

    public void setFrame(String frame){
        this.frame = frame;
    };




}
