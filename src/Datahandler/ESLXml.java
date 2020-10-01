package Datahandler;

import javax.xml.bind.annotation.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Vinicius
 * 30.Sep 2020
 * Version: 1.0
 */
@XmlRootElement(name = "ESLBillingData")
public class ESLXml {

    private ArrayList<TimePeriod> timePeriodList;

    public ESLXml() {

    }

    @XmlElementWrapper(name = "Meter")
    @XmlElement(name = "TimePeriod")
    public ArrayList<TimePeriod> getTimePeriodList() {
        return timePeriodList;
    }
}

@XmlRootElement(name = "TimePeriod")
class TimePeriod {
    @XmlAttribute(name = "end")
    private String end;
    private ArrayList<Values> valuesList;

    TimePeriod(String end){
        this.end = end;
    }

    public Timestamp getTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm:ss");
        LocalDateTime localDate = LocalDateTime.parse(end, formatter);
        return Timestamp.valueOf(localDate);
    }

    @XmlElement(name = "ValueRow")
    public ArrayList<Values> getValuesList() {
        return valuesList;
    }
}

@XmlRootElement(name = "ValueRow")
class Values {
    @XmlAttribute(name = "value")
    private String value;
    @XmlAttribute(name = "obis")
    private String obis;
    Values(String value, String time, String obis){
        this.value = value;
        this.obis = obis;
    }

    public double getValue() {
        return Double.parseDouble(value);
    }

    public String getObis() {
        return obis.substring(obis.length()-6, obis.length()-1);
    }
}