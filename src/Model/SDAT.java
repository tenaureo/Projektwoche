package ch.vator.stromzaehler.Model;

public class SDAT {
    private TimeStamp timeID;
    private int numID;
    private int seqID;
    private double value;


    public TimeStamp getTimeID() {
        return timeID;
    }

    public int getNumID() {
        return numID;
    }

    public int getSeqID() {
        return seqID;
    }

    public double getValue() {
        return value;
    }
}
