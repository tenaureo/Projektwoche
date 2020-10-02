package Datahandler;

import Model.ESL;
import Model.SDAT;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class DataHandler {

    private String dir = System.getProperty("user.dir")+"\\files";
    private ArrayList<File> read = new ArrayList<>();
    private ESLXml eslXml;
    private SDATXml sdatXml;
    private Map<String, SDAT> sdatMap = new HashMap<>();
    private Map<String, ESL> eslMap = new HashMap<>();
    public static final DataHandler DATA_HANDLER = new DataHandler();
    private DataHandler() {

    }

    public DataHandler getInstance() {
        return DATA_HANDLER;
    }

    public void readFiles() throws FileNotFoundException {
        File[] files = new File(dir).listFiles();
        ArrayList<File> esl = new ArrayList<>();
        ArrayList<File> sdat = new ArrayList<>();
        for (File file : files) {
            if (file.getName().startsWith("esl")){
                for (File eslFile : file.listFiles()) {
                    esl.add(eslFile);
                }
            } else if(file.getName().startsWith("sdat")){
                for (File sdatFile : file.listFiles()) {
                    sdat.add(sdatFile);
                }
            }
        }
        read = sdat;
        readSDAT();
        read = esl;
        readESL();
    }

    public void readSDAT(){
        List<Class<? extends SDATXml>> sdats = Arrays.asList(SDAT12.class, SDAT13.class, SDAT14.class);
        for(Class sdat : sdats) {
            try {
                double total = 0.0f;
                JAXBContext context = JAXBContext.newInstance(sdat);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                for (File file : read) {
                    sdatXml = (SDATXml) unmarshaller.unmarshal(file);
                    if (!sdatMap.containsKey(sdatXml.getTime().toString())) {
                        for (Metering meters : sdatXml.getMetering()) {
                            for (Observations obs : meters.getObservations()) {
                                if (!sdatMap.containsKey(sdatXml.getTime().toString())) {
                                    sdatMap.put(sdatXml.getTime().toString(), new SDAT(sdatXml.getTime(), sdatXml.getNumID(), sdatXml.getMeasure(), obs.getSeqID(), obs.getVolume()));
                                } else {
                                    sdatMap.get(sdatXml.getTime().toString()).addValue(obs.getSeqID(), obs.getVolume());
                                }
                            }
                        }
                    }
                }
            } catch (JAXBException ignored) {

            }
        }
    }

    public void readESL() throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(ESLXml.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            for (File file : read) {
                eslXml = (ESLXml) unmarshaller.unmarshal(file);
                for (Meter meter : eslXml.getMeterList()) {
                    for (TimePeriod timePeriod : meter.getTimePeriodList()) {
                        if (!eslMap.containsKey(timePeriod.getTime().toString())) {
                            for (Values value : timePeriod.getValuesList()) {
                                String obis = value.getObis();
                                switch(obis){
                                    case "1.8.1":
                                    case "1.8.2":
                                    case "2.8.1":
                                    case "2.8.2":
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

    public Map<String, SDAT> getSdatMap() {
        return sdatMap;
    }

    public Map<String, ESL> getEslMap() {
        return eslMap;
    }
}