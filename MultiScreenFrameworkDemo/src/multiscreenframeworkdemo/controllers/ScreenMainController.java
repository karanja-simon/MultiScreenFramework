/*
 * The MIT License
 *
 * Copyright 2017 Karanja.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package multiscreenframeworkdemo.controllers;

import com.zilabs.multiscreenframework.core.ScreenLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import multiscreenframeworkdemo.screens.Screens;

/**
 * FXML Controller class
 *
 * @author Karanja
 */
public class ScreenMainController implements Initializable{

    // Initialize screen loader
    private final ScreenLoader loader = new ScreenLoader();
    private final Screens screen = Screens.getInstance();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loader.setWrapperAnchorPane(wrapperAnchorPane);

            loader.loadScreen(screen.SCREEN_1_NAME, screen.PACKAGE_VIEW + screen.SCREEN_1_FXML);
            loader.loadScreen(screen.SCREEN_2_NAME, screen.PACKAGE_VIEW + screen.SCREEN_2_FXML);
            loader.loadScreen(screen.SCREEN_3_NAME, screen.PACKAGE_VIEW + screen.SCREEN_3_FXML);
            
            // Load the initial (first) screen
            loader.setScreen(screen.SCREEN_1_NAME);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private AnchorPane wrapperAnchorPane;

    @FXML
    private void handleButton001Action(ActionEvent event) {
        loader.setScreen(screen.SCREEN_1_NAME);
        System.out.println("Screen 001 loaded");
    }

    @FXML
    private void handleButton002Action(ActionEvent event) {
        loader.setScreen(screen.SCREEN_2_NAME);
        System.out.println("Screen 002 loaded");
    }

    @FXML
    private void handleButton003Action(ActionEvent event) {
        loader.setScreen(screen.SCREEN_3_NAME);
        System.out.println("Screen 003 loaded");
    }

}
