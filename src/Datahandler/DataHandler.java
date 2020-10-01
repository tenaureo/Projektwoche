package Datahandler;

import Model.ESL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vator
 * @version 1.0
 * @since 2020-September-30
 */

public class DataHandler {

    private String dir = "C:\\Users\\Vinicius\\IdeaProjects\\test\\ESL-Files";
    private ArrayList<File> read = new ArrayList<>();
    private ESLXml eslXml;
    //private  Map<String, SDAT> sdatMap;
    private Map<String, ESL> eslMap = new HashMap<>();
    private static final DataHandler DATA_HANDLER = new DataHandler();
    private DataHandler() {

    }

    public DataHandler getDataHandler() {
        return DATA_HANDLER;
    }

    public void readFiles() throws FileNotFoundException {
        File[] files = new File("C:\\Users\\Vinicius\\IdeaProjects\\test").listFiles();
        for (File file : files) {
            if (file.getName().startsWith("ESL")){
                if (read != null) {
                    read.clear();
                }
                for (File eslFile : file.listFiles()) {
                    read.add(eslFile);
                }
                readESL();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        DataHandler dh = DataHandler.DATA_HANDLER;
        dh.readFiles();
    }
    public void readSdat(){

    }

    public void readESL() throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(ESLXml.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            for (File file : read) {
                eslXml = (ESLXml) unmarshaller.unmarshal(file);
                System.out.println(file.toString());
                for (Meter meter : eslXml.getMeterList()) {
                    for (TimePeriod timePeriod : meter.getTimePeriodList()) {
                        System.out.println(timePeriod.getTime().toString());
                        if (!eslMap.containsKey(timePeriod.getTime().toString())) {
                            for (Values value : timePeriod.getValuesList()) {
                                String obis = value.getObis();
                                switch(obis){
                                    case "1.8.1":
                                    case "1.8.2":
                                    case "2.8.1":
                                    case "2.8.2":
                                        System.out.println(value.getValue());
                                        if(eslMap.containsKey(timePeriod.getTime().toString())){
                                            eslMap.get(timePeriod.getTime().toString()).addValue(value.getValue());
                                        } else {
                                            eslMap.put(timePeriod.getTime().toString(), new ESL(timePeriod.getTime(), value.getValue()));
                                        }
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (JAXBException e){
            e.printStackTrace();
        }
    }

    public void addSdat(){

    }

    public void addESL(){

    }

    //public Map<String, SDAT> getSdatMap() {
    //    return sdatMap;
    //}

    public Map<String, ESL> getEslMap() {
        return eslMap;
    }
}
