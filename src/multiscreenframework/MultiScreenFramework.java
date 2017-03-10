/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiscreenframework;

import com.zilabs.multiscreenframework.core.ScreenLoader;
import com.zilabs.multiscreenframework.interfaces.IScreenController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Karanja
 */
public class MultiScreenFramework extends Application implements IScreenController {
    
    @Override
    public void start(Stage primaryStage) {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
    }

    @Override
    public void setScreenParent(ScreenLoader loader) {
     
    }
    
}
