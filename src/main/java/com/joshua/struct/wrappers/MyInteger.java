package com.joshua.struct.wrappers;


import com.joshua.struct.utilities.*;

/**
 * Created by joshua on 2017/9/6.
 */
public class MyInteger implements Operable, Zero, CloneableObject {
    // value of the integer
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    /** input from the given input stream */
    public static MyInteger input(MyInputStream stream)
    {
        System.out.println("Enter an integer value");
        return new MyInteger(stream.readInteger());
    }

    @Override
    public Object add(Object x) {
        return new MyInteger(value + ((MyInteger) x ).value);
    }

    @Override
    public Object subtract(Object x) {
        return null;
    }

    @Override
    public Object multiply(Object x) {
        return null;
    }

    @Override
    public Object divide(Object x) {
        return null;
    }

    @Override
    public Object mod(Object x) {
        return null;
    }

    @Override
    public Object increment(Object x) {
        return null;
    }

    @Override
    public Object decrement(Object x) {
        return null;
    }

    @Override
    public Object zero() {
        return null;
    }

    @Override
    public Object identity() {
        return null;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public boolean equalsZero() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        int y = ((MyInteger)o).value;
        if (value < y)
            return -1;
        if (value == y)
            return 0;
        return 1;
    }
}
