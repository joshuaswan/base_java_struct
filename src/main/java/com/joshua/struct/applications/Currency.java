package com.joshua.struct.applications;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by joshua on 2016/12/5.
 */
public class Currency {

    //data and method members of Currency come here

    //class constants
    public static final boolean PLUS=true;
    public static final boolean MINUS = false;
    public static final NumberFormat TWODIGIT = new DecimalFormat("00");

    //instance data members
    private boolean sign;
    private long dollars;
    private byte cents;

    //Constructors

    /**
     * initialize instance to sign $ dollars cents
     * @throws IllegalArgumentException when dollars < 0
     * or cents < 0 or cents > 99
     * @param sign
     * @param dollars
     * @param cents
     */
    public Currency(boolean sign, long dollars, byte cents) {
        this.sign = sign;
        if (dollars<0){
            throw new IllegalArgumentException("Dollar value must be >= 0");
        }else {
            this.dollars = dollars;
        }
        if (cents < 0|| cents>99){
            throw new IllegalArgumentException("Cents must be between 0 and 99");
        }else {
            this.cents = cents;
        }
    }

    /**
     * initialize instance to $0.00
     */
    public Currency() {
        this(PLUS,0L,(byte)0);
    }

    /**
     * initialize with double
     * @param value
     */
    public Currency(double value) {
        setValue(value);
    }

    /**
     * set sign, dollars, and cents
     * @param value
     */
    public void setValue(double value) {
        if (value<0){
            sign = MINUS;
            value = -value;
        }else {
            sign = PLUS;
            dollars = (long) value;//extract integral part

            //get two decimal digits
            cents = (byte) ((value + 0.005 -dollars) * 100);
        }
    }

    public void setValue(Currency x){
        sign = x.sign;
        dollars = x.dollars;
        cents = x.cents;
    }

    /**
     * @return sign
     */
    public boolean isSign() {
        return sign;
    }

    /**
     * @return dollars
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * @return cents
     */
    public byte getCents() {
        return cents;
    }

    /**
     * set sign = sign
     * @param sign
     */
    public void setSign(boolean sign) {
        this.sign = sign;
    }

    /**
     * set dollars = dollars
     * @param dollars
     */
    public void setDollars(long dollars) {
        if (dollars<0){
            throw new IllegalArgumentException("Dollar value must be >= 0");
        }else {
            this.dollars = dollars;
        }
    }

    /**
     * set cents = cents
     * @param cents
     */
    public void setCents(byte cents) {
        if (cents < 0|| cents > 99){
            throw new IllegalArgumentException("Cents must be between 0 and 99");
        }else {
            this.cents = cents;
        }
    }

    /**
     *
     * @return convert to a string
     */
    @Override
    public String toString() {
        if (sign == PLUS){
            return "$" + dollars + "." + TWODIGIT.format(cents);
        }else {
            return "-$" + dollars + "." + TWODIGIT.format(cents);
        }
    }

    //arithmetic methods
    /**
     * @param x
     * @return this + x
     */
    public Currency add(Currency x){
        //convert this to a long
        long a1 = dollars * 100 + cents;
        if (sign == MINUS){
            a1 = -a1;
        }

        //convert x to a long
        long a2 = x.dollars * 100 + x.cents;
        if (x.sign == MINUS){
            a2 = -a2;
        }

        long a3 = a1 + a2;

        //convert result to Currency object
        Currency answer = new Currency();
        if (a3<0){
            answer.sign = MINUS;
            a3 = -a3;
        }else {
            answer.sign = PLUS;
        }
        answer.dollars = a3 /100;
        answer.cents = (byte) (a3 - answer.dollars * 100);

        return answer;
    }

    /**
     * @param x
     * @return this incremented by x
     * */
    public Currency increment(Currency x){
        setValue(add(x));
        return this;
    }
}
