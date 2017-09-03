package com.joshua.struct.exam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTrackTest {

    SquareTrack squareTrack = null;

    @Before
    public void before(){
        squareTrack = new SquareTrack(10,4);
    }

    @Test
    public void area() throws Exception {
        System.out.println("area");
        System.out.println(squareTrack.area());
    }

    @Test
    public void perimeter() throws Exception {
        System.out.println("perimeter");
        System.out.println(squareTrack.perimeter());
    }

    @Test
    public void printAp() throws Exception {
        System.out.println("print");
        squareTrack.printAp();
    }
}