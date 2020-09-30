package View;

import Control.Processing;
import Datahandler.DataHandler;
import Model.SDAT;
import model.ESL;

import java.awt.*;
import java.util.Map;

/**
 * @author Vator
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