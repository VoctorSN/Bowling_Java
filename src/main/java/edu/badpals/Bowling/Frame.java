package edu.badpals.Bowling;

public class Frame {
    private String frame;

    public Frame(String frame){
        this.frame = frame;
    }
    private int GetScoreByPin(char pin) {
        int Score = 0;
        if (pin == '/' || pin == 'X'){
            Score = 10;
        }
        if (pin != '-'){
            Score = Character.getNumericValue(pin);
        }
        return Score;
    }
    public int calculate_frame_puntuation(String frame){
        char first_roll = frame.charAt(0);
        if (is_strike(first_roll)){
            return GetScoreByPin(first_roll);
        }
        char second_roll = frame.charAt(1);
        if (is_spare(second_roll)){
            return GetScoreByPin(second_roll);
        }
        return GetScoreByPin(first_roll) + GetScoreByPin(second_roll);
    }
    public boolean is_spare(String frame){
        return frame.charAt(1) == '/';
    }
    public boolean is_spare(char pin) {
        return pin == '/';
    }

    public boolean is_strike(String frame){
        return frame.charAt(1) == 'X';
    }
    public boolean is_strike(char pin) {
        return pin == 'X';
    }






}
