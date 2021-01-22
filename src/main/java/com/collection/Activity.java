package com.collection;

public class Activity {

    private int start;
    private int end;

    public Activity(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(final int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(final int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
