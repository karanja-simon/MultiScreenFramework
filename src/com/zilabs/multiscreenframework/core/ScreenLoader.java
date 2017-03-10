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
package com.zilabs.multiscreenframework.core;

import com.zilabs.multiscreenframework.animations.AnimationSettings;
import com.zilabs.multiscreenframework.animations.Animator;
import com.zilabs.multiscreenframework.interfaces.IScreenController;
import com.zilabs.multiscreenframework.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @version 2.0.1
 * @author S.Karanja <dev.zilabs@gmail.com>
 *
 * This is the core class loads or unloads a screen/Node (AnchorPane) based on
 * it's id. The implementation uses a HashMap to store nodes with their
 * corresponding id.
 *
 */
public class ScreenLoader {

    private final HashMap<String, Node> screens = new HashMap<>();

    private final Animator animate = new Animator();
    private boolean allowAnimation = false;
    private int animationDuration = 1000;
    private boolean animationOne = true;
    private AnchorPane wrapperAnchorPane;

    /**
     * Sets the parent container, i.e the container that will wraps/hold the
     * screens you wish to load later.
     * <b>[NOTE] This wrapper/container should be SPECIFICALLY a JavaFX
     * AnchorPane.</b>
     *
     * @param anchor    - The base AnchorPane container that will hold other nodes
     *                    and their UI components.
     */
    public void setWrapperAnchorPane(AnchorPane anchor) {
        this.wrapperAnchorPane = anchor;
    }

    /**
     * Add a specific screen to a HashMap which will be later displayed upon
     * request. [NOTE] The node should be any JavaFX container, preferably but
     * not limited to a AnchorPane.
     *
     * @param screenId  - The ID of the screen to be added, it be the name, e.g
     *                    screen.1
     * @param node      - The actual container from the .fxml file
     */
    private void addScreen(String screenId, Node node) {
        screens.put(screenId, node);
    }

    /**
     * Retrieves a specified screen using the screenId. It looks for a screen
     * with a given id from the array/hashmap of registered screens.
     *
     * @param screenId  - The ID of the screen you want retrieved.
     * @return Node     - The Screen requested.
     */
    public Node getScreen(String screenId) {
        return screens.get(screenId);
    }

    /**
     * Sets the animation duration. The duration is expressed in seconds. [NOTE]
     * Ensure the duration is not set to a high value, otherwise the animation
     * may run very slow.
     *
     * @param t - Duration time in seconds.
     */
    public void setAnimationDuration(int t) {
        this.animationDuration = t;
    }

    /**
     * This method sets the animation to ON or OFF. If the settings is set to
     * ON, then the system uses the predefined animation i.e, the fade
     * animation.
     *
     * @param as    - The settings option i.e AnimationSettings.ANIMATION_ON or
     *                AnimationSettings.ANIMATION_OFF
     */
    public void allowAnimation(AnimationSettings as) {
        switch (as) {
            case ANIMATION_ON:
                allowAnimation = true;
                break;
            case ANIMATION_OFF:
                allowAnimation = false;
                break;
        }
    }

    /**
     * Sets the animation type. There are two default animation types, i.e Slide
     * & Fade animation. The Slide animation slides the node from left to right
     * on the screen. The Fade animation fades the node by adjusting its opacity
     * from 0 to 1 over time.
     *
     * @param as    - Animation type, i.e AnimationSettings.ANIMATION_SLIDE,
     *                AnimationSettings.ANIMATION_FADE.
     */
    public void setAnimationType(AnimationSettings as) {
        switch (as) {
            case ANIMATION_FADE:
                animationOne = true;
                break;
            case ANIMATION_SLIDE:
                animationOne = false;
                break;
        }
    }

    /**
     * This method loads a view from the .fxml resource file. The view should be
     * wrapped in an AnchorPane, i.e the topmost container should be an
     * AnchorPane. [NOTE] Once the screens/view are loaded they are added to the
     * screens HashMap BUT they are not LOADED to the scenegraph yet.
     *
     * @param screenId              - The Id name of the screen to be loaded.
     * @param resource              - The corresponding .fxml associated with the screedId.
     * @throws java.io.IOException  - An IOException if a resource file is not is
     * not found.
     */
    public void loadScreen(String screenId, String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
        AnchorPane viewAnchorPane = (AnchorPane) fxmlLoader.load();
        IScreenController myScreenControler = fxmlLoader.<IScreenController>getController();
        myScreenControler.setScreenParent(this);
        addScreen(screenId, viewAnchorPane);
    }

    /**
     * First, this method checks if a specified screen exists with the
     * corresponding screenID, if it's the case, it checks if any view is loaded
     * in the parent AnchorPane, if not the screen/view is added to parent,
     * otherwise, the parent is cleared of any children and the screen/view is
     * added on the scene graph.
     *
     * @param screenId  - The Id of the view/screen to load.
     * @return          - True if the screen was loaded successfully, false otherwise.
     */
    public boolean setScreen(final String screenId) {
        if (screens.get(screenId) != null) {
            Utils.allowStrech(true, screens.get(screenId));
            if (!wrapperAnchorPane.getChildren().isEmpty()) {
                wrapperAnchorPane.getChildren().remove(0);
                wrapperAnchorPane.getChildren().add(0, screens.get(screenId));
                if (allowAnimation) {
                    if (animationOne) {
                        animate.fadeOut(wrapperAnchorPane, animationDuration).play();
                    } else {
                        animate.slideIn(wrapperAnchorPane, animationDuration).play();
                    }

                }
            } else {
                wrapperAnchorPane.getChildren().add(screens.get(screenId));
                if (allowAnimation) {
                    if (animationOne) {
                        animate.fadeOut(wrapperAnchorPane, animationDuration).play();
                    } else {
                        animate.slideIn(wrapperAnchorPane, animationDuration).play();
                    }

                }
            }
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
        return true;
    }

    /**
     * First, this method checks if a specified screen exists with the
     * corresponding screenID, if it's the case, it checks if any view is loaded
     * in the parent AnchorPane, if not the screen/view is added to parent,
     * otherwise, the parent is cleared of any children and the screen/view is
     * added on the scene graph.
     *
     * @param screenId  - The Id of the view/screen to load.
     * @param b         - True if scaling is desired, false otherwise.
     * @return          - True if the screen was loaded successfully, false otherwise.
     */
    public boolean setScreen(final String screenId, boolean b) {
        if (screens.get(screenId) != null) {
            Utils.allowStrech(b, screens.get(screenId));
            if (!wrapperAnchorPane.getChildren().isEmpty()) {
                wrapperAnchorPane.getChildren().remove(0);
                wrapperAnchorPane.getChildren().add(0, screens.get(screenId));
                if (allowAnimation) {
                    if (animationOne) {
                        animate.fadeOut((AnchorPane) screens.get(screenId), animationDuration).play();
                    } else {
                        animate.slideIn((AnchorPane) screens.get(screenId), animationDuration).play();
                    }

                }
            } else {
                wrapperAnchorPane.getChildren().add(screens.get(screenId));
                if (allowAnimation) {
                    if (animationOne) {
                        animate.fadeOut((AnchorPane) screens.get(screenId), animationDuration).play();
                    } else {
                        animate.slideOut((AnchorPane) screens.get(screenId), animationDuration).play();
                    }

                }
            }
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
        return true;
    }

}
