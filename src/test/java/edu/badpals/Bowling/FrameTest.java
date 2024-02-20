package edu.badpals.Bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class FrameTest {
    @Test
    public void getFrameTest() {
        Frame frame = new Frame("1/");
        assertEquals("1/", frame.getFrame());
    }
    @Test
    public void setFrameTest() {
        Frame frame = new Frame("1/");
        frame.setFrame("X");
        assertEquals("X", frame.getFrame());
    }
    @Test
    public void calculateFrameTest() {
        Frame frame = new Frame("1/");
        assertEquals(10, frame.calculate_frame_puntuation());
        frame.setFrame("X");
        assertEquals(10, frame.calculate_frame_puntuation());
        frame.setFrame("15");
        assertEquals(6, frame.calculate_frame_puntuation());
        frame.setFrame("43");
        assertEquals(7, frame.calculate_frame_puntuation());
    }
    @Test
    public void isSpareTest() {
        Frame frame = new Frame("1/");
        assertTrue(frame.is_spare());
        frame.setFrame("X");
        assertFalse(frame.is_spare());
        frame.setFrame("15");
        assertFalse(frame.is_spare());

        assertTrue(frame.is_spare('/'));
        assertFalse(frame.is_spare('X'));
        assertFalse(frame.is_spare('5'));
    }
    @Test
    public void isStrikeTest() {
        Frame frame = new Frame("X");
        assertTrue(frame.is_strike());
        frame.setFrame("1/");
        assertFalse(frame.is_strike());
        frame.setFrame("15");
        assertFalse(frame.is_strike());

        assertTrue(frame.is_strike('X'));
        assertFalse(frame.is_strike('/'));
        assertFalse(frame.is_strike('5'));
    }
}

/*
frame = new Frame("1/");
        System.out.println(frame.getFrame());
        System.out.println(frame.calculate_frame_puntuation());
        System.out.println(frame.is_spare());
        System.out.println(frame.is_strike());
        frame.setFrame("X");
        System.out.println(frame.getFrame());
        System.out.println(frame.calculate_frame_puntuation());
        System.out.println(frame.is_spare());
        System.out.println(frame.is_strike());
        frame.setFrame("15");
        System.out.println(frame.getFrame());
        System.out.println(frame.calculate_frame_puntuation());
        System.out.println(frame.is_spare());
        System.out.println(frame.is_strike());
 */