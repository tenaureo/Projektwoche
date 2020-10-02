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

@XmlRootElement(name = "ValidatedMeteredData_12")
public class SDATXml {

    @XmlElement(name = "ValidatedMeteredData_HeaderInformation")
    private String numID = new Header().getDocumentID();

    @XmlElement(name = "MeteringData")
    private String measure = new Measure().getMeasure();

    @XmlElement(name = "MeteringData")
    private Timestamp timeID = new StartDate().getTime();

    private ArrayList<Metering> meterings;

    public SDATXml() {

    }

    @XmlElement(name = "MeteringData")
    public ArrayList<Metering> getMetering(){
        if (meterings == null){
            meterings = new ArrayList<Metering>();
        }
        return meterings;
    }

    public String getNumID() {
        return numID;
    }

    public Timestamp getTimeID() {
        if (timeID == null){
            timeID = Timestamp.valueOf("2000-07-07 19:00:00Z");
        }
        return timeID;
    }

    public String getMeasure() {
        return measure;
    }
}

@XmlRootElement(name = "ValidatedMeteredData_HeaderInformation")
class Header{

    @XmlElement(name = "InstanceDocument")
    private String documentID = new DocumentID().getDocumentID();

    public Header(){

    }

    public String getDocumentID() {
        return documentID;
    }
}

@XmlRootElement(name = "InstanceDocument")
class DocumentID{

    @XmlElement(name = "DocumentID")
    private String documentID;

    public DocumentID(){

    }

    public String getDocumentID() {
        return documentID.substring(documentID.length()-5);
    }
}

@XmlRootElement(name = "MeteringData")
class Metering{

    private ArrayList<Observations> observations;

    public Metering(){

    }

    @XmlElement(name = "Observation")
    public ArrayList<Observations> getObservations(){
        if (observations == null){
            observations = new ArrayList<>();
        }
        return observations;
    }
}

@XmlRootElement(name = "Observation")
class Observations{
    private ArrayList<Double> volumeList;
    private ArrayList<Integer> seqIDList;

    public Observations(){

    }

    @XmlElement(name = "Volume")
    public ArrayList<Double> getVolume(){
        if (volumeList == null){
            volumeList = new ArrayList<Double>();
        }
        return volumeList;
    }

    @XmlElement(name = "Position")
    public ArrayList<Integer> getSeqID(){
        if (seqIDList == null){
            seqIDList = new ArrayList<Integer>();
        }
        return seqIDList;
    }
}

@XmlRootElement(name = "Position")
class Position {
    @XmlAttribute(name = "Sequence")
    private int pos;

    private Position(){

    }

    public int getPos() {
        return pos;
    }
}

@XmlRootElement(name = "Interval")
class StartDate {

    @XmlElement(name = "StartDateTime")
    private String time;

    public StartDate(){

    }

    public Timestamp getTime(){
        time = time.replace('T', ' ');
        return Timestamp.valueOf(time);
    }
}

@XmlRootElement(name = "Product")
class Measure {

    @XmlElement(name = "MeasureUnit")
    private String measure;

    public Measure(){

    }

    public String getMeasure(){
        return measure;
    }
}