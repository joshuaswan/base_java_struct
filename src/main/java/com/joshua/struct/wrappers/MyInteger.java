package com.joshua.struct.wrappers;


import com.joshua.struct.utilities.*;

/**
 * Created by joshua on 2017/9/6.
 */
public class MyInteger implements Operable, Zero, CloneableObject {
    // value of the integer
    private int value;

    // constructor methods
    /** MyInteger initialized to theValue */
    public MyInteger(int theValue)
    {value = theValue;}

    /** MyInteger initialized to 0 */
    public MyInteger()
    {this(0);}

    /** MyInteger initialized to s */
    public MyInteger(String s)
            throws NumberFormatException
    {value = Integer.parseInt(s);}

    // accessor methods
    /** @return value of the integer */
    public int getValue() {return value;}
    public int intValue() {return value;}
    public int hashCode() {return value;}

    // mutator value
    /** set value to theValue */
    public void setValue(int theValue)
    {value = theValue;}

    // convert to String, useful for output
    /** @return integer in String format */
    public String toString()
    {return Integer.toString(value);}

    /** input from the given input stream */
    public static MyInteger input(MyInputStream stream)
    {
        System.out.println("Enter an integer value");
        return new MyInteger(stream.readInteger());
    }

    /** make a clone */
    public Object clone()
    {return new MyInteger(value);}

    // Computable interface methods
    /** @return this + x */
    public Object add(Object x)
    {
        return new MyInteger
                (value + ((MyInteger) x).value);
    }

    /** @return this - x */
    public Object subtract(Object x)
    {
        return new MyInteger
                (value - ((MyInteger) x).value);
    }

    /** @return this * x */
    public Object multiply(Object x)
    {
        return new MyInteger
                (value * ((MyInteger) x).value);
    }

    /** @return this / x */
    public Object divide(Object x)
    {
        return new MyInteger
                (value / ((MyInteger) x).value);
    }

    /** @return remainder of this / x */
    public Object mod(Object x)
    {
        return new MyInteger
                (value % ((MyInteger) x).value);
    }

    /** @return this incremented by x */
    public Object increment(Object x)
    {
        value += ((MyInteger) x).value;
        return this;
    }

    /** @return this decremented by x */
    public Object decrement(Object x)
    {
        value -= ((MyInteger) x).value;
        return this;
    }

    /** @return a new copy of 0 */
    public Object zero()
    {return new MyInteger(0);}

    /** @return true iff value == 0 */
    public boolean equalsZero()
    {return value == 0;}

    /** @return a new copy of 1 */
    public Object identity()
    {return new MyInteger(1);}

    // Comparable interface method
    /** @return -1 if this < x,
     *          0 if this == x,
     *          1 if this > x */

    public int compareTo(Object x)
    {
        int y = ((MyInteger) x).value;
        if (value < y) return -1;
        if (value == y) return 0;
        return 1;
    }

    // override Object.equals
    /** @return true iff this == x */
    public boolean equals(Object x)
    {return value == ((MyInteger) x).value;}
}
