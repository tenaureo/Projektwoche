package Control;

import Model.SDAT;
import Model.ESL;

import java.util.Map;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class Processing {
    private Map<String, ESL> eslMap;
    private Map<String, SDAT> sdatMap;

    public Map<String, ESL> getEslMap() {
        return eslMap;
    }

    public void setEslMap(Map<String, ESL> eslMap) {
        this.eslMap = eslMap;
    }

    public Map<String, SDAT> getSdatMap() {
        return sdatMap;
    }

    public void setSdatMap(Map<String, SDAT> sdatMap) {
        this.sdatMap = sdatMap;
    }

    public Processing(){


    }

    public void sortData(){

    }
}
