package Model;

import java.sql.Timestamp;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class ESL {
    private Timestamp timeID;
    private int increment = 0;
    private double[] value = new double[4];

    public ESL(Timestamp timeID, double value){
        this.timeID = timeID;
        this.value[increment] = value;
        increment++;
    }

    public Timestamp getTimeID() {
        return timeID;
    }

    public void addValue(double value){
        this.value[increment] = value;
        increment++;
    }

    public double getValue(String selection) {
        switch (selection){
            case "high":
                return value[0]-value[3];
            case "low":
                return value[2]-value[4];
            default:
                return 0.0f;
        }
    }
}