package com.joshua.struct.applications;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by joshua on 2016/12/5.
 */
public class Length {

    public static final boolean PLUS=true;
    public static final boolean MINUS = false;
    public static final NumberFormat TWODIGIT = new DecimalFormat("00");

    private boolean sign;
    private long meters;
    private byte centimeters;
    private byte millimeters;

    public long getMeters() {
        return meters;
    }

    public void setMeters(long meters) {
        this.meters = meters;
    }

    public byte getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(byte centimeters) {
        this.centimeters = centimeters;
    }

    public byte getMillimeters() {
        return millimeters;
    }

    public void setMillimeters(byte millimeters) {
        this.millimeters = millimeters;
    }

    public boolean isSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public Length(boolean sign, long meters, byte centimeters, byte millimeters) {
        this.sign = sign;
        if (meters < 0){
            throw new IllegalArgumentException("Meters must be >= 0");
        }else {
            this.meters = meters;
        }
        if (centimeters < 0 || centimeters>99){
            throw new IllegalArgumentException("centimeters must be between 0 and 99");
        }else {
            this.centimeters = centimeters;
        }
        if (millimeters < 0 || millimeters >99){
            throw new IllegalArgumentException("millimeters must be between 0 and 99");
        }else {
            this.millimeters = millimeters;
        }
    }

    public Length() {
    }

    public Length(double length){
        setLength(length);
    }
    public void setLength(double length){
        if (length < 0){
            setSign(MINUS);
            length = -length;
        }else {
            setSign(PLUS);
            meters = (long) length;//extract integral part

            //get the centimeters
            centimeters = (byte) ((length -meters) * 100);

            //get the millimeters
            millimeters = (byte) ((length + 0.00005 - meters - centimeters * 0.01) * 10000);
        }
    }

    public void setLength(Length x){
        sign = x.sign;
        meters = x.meters;
        centimeters = x.centimeters;
        millimeters = x.millimeters;
    }

    @Override
    public String toString() {
        if (sign == true){
            return meters + "." + TWODIGIT.format(centimeters) + TWODIGIT.format(millimeters);
        }else {
            return "-" + meters + "." + TWODIGIT.format(centimeters) + TWODIGIT.format(millimeters);
        }
    }

    public Length add(Length x){
        long a1 = meters * 10000 + centimeters * 100 + millimeters;
        if (sign == MINUS){
            a1 = -a1;
        }

        long a2 = x.meters * 10000 + centimeters * 100 + millimeters;
        if (x.sign == MINUS){
            a2 = -a2;
        }

        long a3 = a1 + a2;

        Length answer = new Length();
        if (a3 < 0){
            answer.sign = MINUS;
            a3 = -a3;
        }else {
            answer.sign = PLUS;
        }
        answer.meters = a3 / 10000;
        answer.centimeters = (byte) ((a3 - answer.meters * 10000 )/100);
        answer.centimeters = (byte) (a3 - answer.meters * 10000 - answer.centimeters * 100);
        return answer;
    }

    public Length increment(Length x){
        setLength(add(x));
        return this;
    }
}
