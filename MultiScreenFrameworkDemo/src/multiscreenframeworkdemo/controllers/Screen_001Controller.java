/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiscreenframeworkdemo.controllers;

import com.zilabs.multiscreenframework.core.ScreenLoader;
import com.zilabs.multiscreenframework.interfaces.IScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Karanja
 */
public class Screen_001Controller implements Initializable, IScreenController {

    private ScreenLoader loader;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreenLoader loader) {
        this.loader = loader;
    }
    
}
