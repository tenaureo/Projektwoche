package View;

import Datahandler.DataHandler;
import model.ESL;

import java.awt.*;
import java.util.Map;

/**
 * @author Moritz Meier
 * @version 1.0
 * @since 2020-September-30
 */

public class View {
    private Map<String, SDAT> sdatMap;
    private Map<String, ESL> eslMap;

    private DataHandler dataHandler;
    private Processing processing;
    private CardLayout cardLayout;

    public View(){

    }

}