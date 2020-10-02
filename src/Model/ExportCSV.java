package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class ExportCSV {

    private Map<String, ESL> eslMap;
    private Map<String, SDAT> sdatMap;


    public ExportCSV(Map<String, ESL> eslMap, Map<String, SDAT> sdatMap){
        this.eslMap = eslMap;
        this.sdatMap = sdatMap;
    }

    public void writeCSV(File file){

        try (PrintWriter writer = new PrintWriter(new File(String.valueOf(file)+"/Zaehlerdaten.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("ESL:");
            sb.append('\n');
            sb.append("timestamp,");
            sb.append(',');
            sb.append("value");
            sb.append('\n');

            for (int i = 0; i < eslMap.size()-1; i++) {
                sb.append("test");
                sb.append(',');
                sb.append("test");
                sb.append('\n');
            }

            sb.append("sdat:");
            sb.append('\n');
            sb.append("timestamp,");
            sb.append(',');
            sb.append("value");
            sb.append('\n');

            for (int i = 0; i < sdatMap.size()-1; i++) {
                sb.append("test");
                sb.append(',');
                sb.append("test");
                sb.append('\n');
            }

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
