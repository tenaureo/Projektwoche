package Control;

import Datahandler.DataHandler;
import Model.SDAT;
import Model.ESL;
import java.util.*;


/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */
public class Processing {

    private Map<String, ESL> eslMap;
    private Map<String, SDAT> sdatMap;
    public static final Processing PROCESSING = new Processing();

    private Processing(){
        sortData();
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
        eslMap = DataHandler.DATA_HANDLER.getEslMap();
        sdatMap = DataHandler.DATA_HANDLER.getSdatMap();

        TreeMap<String, ESL> newESLMap = new TreeMap<>(eslMap);
        TreeMap<String, SDAT> newSDATMap = new TreeMap<>(sdatMap);
        /**
         TreeSet<String> keyset = new TreeSet<String>();
         for (String s: eslMap.keySet()) {
         keyset.add(s);
         }
         HashMap<String, ESL> newESLMap = new HashMap<String, ESL>();
         for(String s :keyset){
         newESLMap.put(s, eslMap.get(s));
         }
         eslMap = newESLMap;
         }

                //the sorted data can be filtered by choosing a time span from which they want to see the data

        *
         public void filterbyDate(int low, int high) throws ParseException {
         String from;
         String today = LocalDate.now().toString();
         String to;
         DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
         Date date1 = format.parse(from);
         Date date2 = format.parse(today);
         Date date3 = format.parse(to);
         if(date1.before(date2) && date3.after(date2)){
         }
         }*/
    }
}