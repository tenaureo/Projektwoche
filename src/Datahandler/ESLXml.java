package Datahandler;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

@XmlRootElement(name = "ESLBillingData", namespace = "")
public class ESLXml {

    private ArrayList<Meter> meterList;

    public ESLXml() {

    }
    @XmlElement(name = "Meter", namespace = "")
    public ArrayList<Meter> getMeterList() {
        if(meterList == null){
            meterList = new ArrayList<Meter>();
        }
        return meterList;
    }
}

@XmlRootElement(name = "Meter", namespace = "")
class Meter {
    private ArrayList<TimePeriod> timePeriodList;

    public Meter() {

    }

    @XmlElement(name = "TimePeriod", namespace = "")
    public ArrayList<TimePeriod> getTimePeriodList() {
        if(timePeriodList == null){
            timePeriodList = new ArrayList<TimePeriod>();
        }
        return timePeriodList;
    }
}

@XmlRootElement(name = "TimePeriod", namespace = "")
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
        return Timestamp.valueOf(end);
    }

    @XmlElement(name = "ValueRow", namespace = "")
    public ArrayList<Values> getValuesList() {
        if(valuesList == null){
            valuesList = new ArrayList<Values>();
        }
        return valuesList;
    }
}

@XmlRootElement(name = "ValueRow", namespace = "")
class Values {
    @XmlAttribute(name = "value", namespace = "")
    private String value;
    @XmlAttribute(name = "obis", namespace = "")
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