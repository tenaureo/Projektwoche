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

    private ArrayList<Meter> meterList;

    public ESLXml() {

    }
    @XmlElement(name = "Meter")
    public ArrayList<Meter> getMeterList() {
        if(meterList == null){
            meterList = new ArrayList<Meter>();
        }
        return meterList;
    }
}

@XmlRootElement(name = "Meter")
class Meter {
    private ArrayList<TimePeriod> timePeriodList;

    public Meter() {

    }

    @XmlElement(name = "TimePeriod")
    public ArrayList<TimePeriod> getTimePeriodList() {
        if(timePeriodList == null){
            timePeriodList = new ArrayList<TimePeriod>();
        }
        return timePeriodList;
    }
}

@XmlRootElement(name = "TimePeriod")
class TimePeriod {
    @XmlAttribute(name = "end")
    private String end;
    private ArrayList<Values> valuesList;

    private TimePeriod() {

    }

    public TimePeriod(String end){
        super();
        this.end = end;
    }

    public Timestamp getTime(){
        end = end.replace('T', ' ');
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDate = LocalDateTime.parse(end, formatter);
        return Timestamp.valueOf(localDate);
    }

    @XmlElement(name = "ValueRow")
    public ArrayList<Values> getValuesList() {
        if(valuesList == null){
            valuesList = new ArrayList<Values>();
        }
        return valuesList;
    }
}

@XmlRootElement(name = "ValueRow")
class Values {
    @XmlAttribute(name = "value")
    private String value;
    @XmlAttribute(name = "obis")
    private String obis;
    private Values(){

    }

    public Values(String value, String time, String obis){
        super();
        this.value = value;
        this.obis = obis;
    }

    public double getValue() {
        return Double.parseDouble(value);
    }

    public String getObis() {
        return obis.substring(obis.length()-5, obis.length());
    }
}