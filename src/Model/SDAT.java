package Model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class SDAT {
    private Timestamp timeID;
    private String numID;
    private String measure;
    private Map<Integer, Double> value = new HashMap<>();

    public SDAT(Timestamp timeID, String numID, String measure, int seqId, double value){
        this.timeID = timeID;
        this.numID = numID;
        this.measure = measure;
        this.value.put(seqId, value);
    }

    public Timestamp getTimeID() {
        return timeID;
    }

    public String getNumID() {
        return numID;
    }

    public String getMeasure() {
        return measure;
    }

    public void addValue(int seqID, double value){
        this.value.put(seqID, value);
    }

    public boolean hasValueID(int id){
        return value.get(id) != null;
    }

    public Map<Integer, Double> getValue(){
        return value;
    }

    public double getTotalValue() {
        double total = 0.0f;
        for (double val : value.values()) {
            total += val;
        }
        return total;
    }
}
