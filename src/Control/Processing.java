package Control;

import Model.SDAT;
import Model.ESL;
import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;




/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */
public class Processing {

    private Map<String, ESL> eslMap;
    private Map<String, SDAT> sdatMap;

    public Processing(){

    }
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

    //sorts data from Hashmap by keys which are Timestamps, ranging from earliest to latest
    public void sortData(){

            Processing pr = new Processing();

            pr.getSdatMap();

            TreeSet<String> keyset = (TreeSet<String>) sdatMap.keySet();

            System.out.println(keyset);
     }

}
