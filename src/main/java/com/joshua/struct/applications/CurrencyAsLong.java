package com.joshua.struct.applications;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by joshua on 2016/12/6.
 */
public class CurrencyAsLong {

    //class constants
    public static final boolean PLUS = true;
    public static final boolean MINUS = false;
    public static final NumberFormat TWODIGIT = new DecimalFormat("00");

    // instance data member
    private long amount;

    // constructors
    /** initialize instance to
     * theSign $ theDollars.theCents
     * @throws IllegalArgumentException when theDollars < 0
     * or theCents < 0 or theCents > 99 */
    public CurrencyAsLong(boolean theSign, long theDollars,
                          byte theCents)
    {
        if (theDollars < 0)
            throw new IllegalArgumentException
                    ("Dollar value must be >= 0");

        if (theCents < 0 || theCents > 99)
            throw new IllegalArgumentException
                    ("Cents must be between 0 and 99");

        amount = theDollars * 100 + theCents;
        if (theSign == MINUS)
            amount = -amount;
    }
    /** initialize instance to $0.00 */
    public CurrencyAsLong()
    {this(PLUS, 0L, (byte) 0);}

    /** initialize with double */
    public CurrencyAsLong(double theValue)
    {setValue(theValue);}

    /** initialize with amount value */
    private CurrencyAsLong(long theAmount)
    {amount = theAmount;}

    // accessor methods

    /** @return sign */
    public boolean getSign()
    {
        if (amount < 0)
            return MINUS;
        else
            return PLUS;
    }

    /** @return dollars */
    public long getDollars()
    {
        if (amount < 0)
            return - amount / 100;
        else
            return amount / 100;
    }

    /** @return cents */
    public byte getCents()
    {
        if (amount < 0)
            return (byte) ((-amount) % 100);
        else
            return (byte) (amount % 100);
    }

    // mutator methods
    /** Set the sign of amount to theSign.
     * For this to work properly amount must be nonzero. */
    public void setSign(boolean theSign)
    {
        // change the sign as necessary
        if ((amount < 0 && theSign == PLUS) ||
                (amount > 0 && theSign == MINUS))
            amount = -amount;
    }

    /** set dollars = theDollars
     * @throws IllegalArgumentException when theDollars < 0 */
    public void setDollars(long theDollars)
    {
        if (theDollars < 0)
            throw new IllegalArgumentException
                    ("Dollar value must be >= 0");
        else
        {
            boolean sign = getSign();
            byte cents = getCents();
            amount = theDollars * 100 + cents;
            if (sign == MINUS)
                amount = -amount;
        }
    }

    /** set cents = theCents
     * throws IllegalArgumentException when theCents < 0 or theCents > 99 */
    public void setCents(byte theCents)
    {
        if (theCents < 0 || theCents > 99)
            throw new IllegalArgumentException
                    ("Cents must be between 0 and 99");
        else
        {
            boolean sign = getSign();
            long dollars = getDollars();
            amount = dollars * 100 + theCents;
            if (sign == MINUS)
                amount = -amount;
        }
    }

    /** set amount */
    public void setValue(double theValue)
    {
        if (theValue < 0)
            amount = (long) (theValue * 100 - 0.5);
        else
            amount = (long) (theValue * 100 + 0.5);
    }

    public void setValue(CurrencyAsLong x)
    {amount = x.amount;}

    /** convert to a string */
    public String toString()
    {
        if (amount >= 0)
        {return "$" + getDollars() + "." + TWODIGIT.format(getCents());}
        else
        {return "-$" + getDollars() + "." + TWODIGIT.format(getCents());}
    }

    // arithmetic methods

    /** @return this + x */
    public CurrencyAsLong add(CurrencyAsLong x)
    {return new CurrencyAsLong(amount + x.amount);}

    /** @return this incremented by x */
    public CurrencyAsLong increment(CurrencyAsLong x)
    {
        amount += x.amount;
        return this;
    }
}
