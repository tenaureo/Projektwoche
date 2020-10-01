package Model;

import java.sql.Timestamp;

/**
 * @author Tenzin Thobten Leduk
 * @version 1.0
 * @since 2020-September-30
 */

public class SDAT {
    private Timestamp timeID;
    private int numID;
    private int seqID;
    private double value;

    public SDAT(Timestamp timeID, int numID, int seqID, double value){
        this.timeID = timeID;
        this.numID = numID;
        this.seqID = seqID;
        this.value = value;
    }

    public Timestamp getTimeID() {
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
