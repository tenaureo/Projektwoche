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

public class SDATXml {

    @XmlElement(name = "ValidatedMeteredData_HeaderInformation")
    private Header numID;

    @XmlElement(name = "MeteringData")
    private Metering meter;

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

    public Timestamp getTime(){
        return meter.getTime();
    }

    public String getNumID() {
        return numID.getDocumentID();
    }

    public String getMeasure() {
        return meter.getMeasure();
    }
}

class Metering{

    @XmlElement(name = "Interval")
    private StartDate time;

    @XmlElement(name = "Product")
    private Product measure;

    @XmlElement(name = "Observation")
    private ArrayList<Observations> observations;

    public Metering(){

    }

    public Timestamp getTime() {
        return time.getTime();
    }

    public String getMeasure() {
        return measure.getMeasure();
    }

    public ArrayList<Observations> getObservations() {
        return observations;
    }
}

class Header{

    @XmlElement(name = "InstanceDocument")
    private DocumentID documentID;

    public Header(){

    }

    public String getDocumentID() {
        return documentID.getDocumentID();
    }
}

class DocumentID{

    @XmlElement(name = "DocumentID")
    private String documentID;

    public DocumentID(){

    }

    public String getDocumentID() {
        return documentID;
    }
}

class Observations{
    @XmlElement(name = "Volume")
    private double volume;
    @XmlElement(name = "Position")
    private int seqID;

    public Observations(){

    }

    public double getVolume(){
        return volume;
    }

    public int getSeqID(){
        return seqID;
    }
}

class StartDate {

    @XmlElement(name = "StartDateTime")
    private String time;

    public StartDate(){

    }

    public Timestamp getTime() {
        time = time.replace('T', ' ');
        return Timestamp.valueOf(time.substring(0, time.length()-1));
    }
}

class Product{

    @XmlElement(name = "MeasureUnit")
    private String measure;

    public Product(){

    }

    public String getMeasure() {
        return measure;
    }
}

@XmlRootElement(name = "ValidatedMeteredData_12")
class SDAT12 extends SDATXml{
    public SDAT12(){
        super();
    }
}

@XmlRootElement(name = "ValidatedMeteredData_13")
class SDAT13 extends SDATXml{
}

@XmlRootElement(name = "ValidatedMeteredData_14")
class SDAT14 extends SDATXml{
}