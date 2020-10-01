package Model;

import java.sql.Timestamp;

/**
 * @author Moritz Meier
 * @version 1.0
 * @since 2020-September-30
 */

public class ESL {
    private Timestamp timeID;
    private String obis;
    private boolean feed;
    private double value;

    public ESL(Timestamp timeID, String obis, boolean feed, double value){
        this.timeID = timeID;
        this.obis = obis;
        this.feed = feed;
        this.value = value;
    }

    public Timestamp getTimeID() {
        return timeID;
    }

    public String getObis() {
        return obis;
    }

    public boolean isFeed() {
        return feed;
    }

    public double getValue() {
        return value;
    }
}
