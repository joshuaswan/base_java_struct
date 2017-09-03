package com.joshua.struct.exam;

public class SquareTrack extends Square {

    private long trackWidth;

    public SquareTrack(long length, long trackWidth) {
        super(length);
        this.trackWidth = trackWidth;
    }

    public long getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(long trackWidth) {
        this.trackWidth = trackWidth;
    }

    @Override
    public long area() {
        return super.area() - (getLength() - trackWidth*2) * (getLength() - trackWidth*2);
    }

    @Override
    public long perimeter() {
        return super.perimeter() + 4 * (getLength() - trackWidth*2);
    }

}
