package Datahandler;

import Model.SDAT;
import Model.ESL;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Vator
 * @version 1.0
 * @since 2020-September-30
 */

public class DataHandler {

    private ESLXml eslXml;
    private  Map<String, SDAT> sdatMap;
    private Map<String, ESL> eslMap;
    private DataHandler dataHandler;

    public void readSdat(){

    }

    public void readESL(){
        eslXml = new ESLXml();
        for (TimePeriod timePeriod : eslXml.getTimePeriodList()) {
            if (!eslMap.containsKey(timePeriod.getTime().toString())) {
                for (Values value : timePeriod.getValuesList()) {
                    String obis = value.getObis();
                    if(obis.endsWith("1.8.1") || obis.endsWith("1.8.2")) {
                        eslMap.put(timePeriod.getTime().toString(), new ESL(timePeriod.getTime(), obis.substring(obis.length()-6), value.getValue()));
                    }
                }
            }
        }
    }

    public void addSdat(){

    }

    public void addESL(){

    }

    public Map<String, SDAT> getSdatMap() {
        return sdatMap;
    }

    public Map<String, ESL> getEslMap() {
        return eslMap;
    }
}
