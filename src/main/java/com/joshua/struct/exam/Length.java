package com.joshua.struct.exam;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

/**
 * Created by joshua on 2017/9/5.
 */
public class Length {
    public static final boolean PLUS = true;
    public static final boolean MINUS = false;
    public static final NumberFormat TWODIGIT = new DecimalFormat("00");

    private boolean sign;
    private byte millimeters;
    private byte centimeters;
    private long meters;

    public Length(boolean sign, byte millimeters, byte centimeters, long meters) {
        this.sign = sign;
        this.millimeters = millimeters;
        this.centimeters = centimeters;
        this.meters = meters;
    }

    public Length() {
    }

    public Length(double length) {

    }

    public void setLength(double length){
        if (length < 0){
            sign = MINUS;
            length = -length;
        }else {
            sign = PLUS;
        }
        meters = (long)length;
        millimeters = (byte) ((long)length * 100 - meters * 100);
        millimeters = (byte) ((long)length * 10000 - meters * 10000 - millimeters*100);
    }

    public void setLength(Length length){
        sign = length.sign;
        meters = length.meters;
        centimeters = length.centimeters;
        millimeters = length.millimeters;
    }

    public boolean isSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public byte getMillimeters() {
        return millimeters;
    }

    public void setMillimeters(byte millimeters) {
        this.millimeters = millimeters;
    }

    public byte getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(byte centimeters) {
        this.centimeters = centimeters;
    }

    public long getMeters() {
        return meters;
    }

    public void setMeters(long meters) {
        if (meters <0){
            throw new IllegalArgumentException("Meters value must be >= 0");
        }else {
            this.meters = meters;
        }
    }

    @Override
    public String toString() {
        if (sign) {
            return meters + "." + TWODIGIT.format(centimeters) + TWODIGIT.format(millimeters) + "m";
        } else {
            return "-" + meters + "." + TWODIGIT.format(centimeters) + TWODIGIT.format(millimeters) + "m";
        }
    }
}
