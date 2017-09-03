package com.joshua.struct.exam;

public class Square {
    private long length;

    public Square(long length) {
        this.length = length;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long area() {
        return length * length;
    }

    public long perimeter() {
        return length * 4;
    }

    public void printAp(){
        System.out.println("The area of the square is " + area());
        System.out.println("The perimeter of the square is " + perimeter());
    }
}
