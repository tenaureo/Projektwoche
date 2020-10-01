package Model;

import java.io.File;
import java.util.Map;

/**
 * @author Vator
 * @version 1.0
 * @since 2020-September-30
 */

public class ExportJSON {

  private Map<String, ESL> eslMap;
  private Map<String, SDAT> sdatMap;
  
  public ExportJSON(Map<String, ESL> eslMap, Map<String, SDAT> sdatMap){
    this.eslMap = eslMap;
    this.sdatMap = sdatMap;

    }

    public void writeJSON(File file){



    }
}
