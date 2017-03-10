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
package com.zilabs.multiscreenframework.animations;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @version 2.0.1
 * @author Karanja <dev.zilabs@gmail.com>
 * 
 * This class applies animation to desired nodes
 * on the scenegraph. The supported animations are
 *  1. Fade animation
 *  2. Slide animation
 * 
 * @todo ~ Add support for more animations
 */
public class Animator {

    /**
     * Fade out animation.The node is displayed by varying it's opacity level
     * form 0 to 1 over the given duration.
     *
     * @param node - Node to animate
     * @param time - Animation duration (seconds)
     * @return :FadeTransition object
     */
    public FadeTransition fadeOut(Node node, int time) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(time), node);
        fadeOut.setFromValue(0.0);
        fadeOut.setToValue(1.0);
        return fadeOut;
    }

    /**
     * Fade in animation.The node is displayed by varying it's opacity level
     * form 1 to 0 over the given duration.
     *
     * @param node - Node to animate
     * @param time - Animation duration (seconds)
     * @return :FadeTransition object
     */
    public FadeTransition fadeIn(Node node, int time) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(time), node);
        fadeIn.setFromValue(1.0);
        fadeIn.setToValue(0.0);
        return fadeIn;
    }

    /**
     * Slides out a node from its current position to it's -width.
     *
     * @param node - Node to animate
     * @param time - Duration of animation
     * @return :TranslateTransition object
     */
    public TranslateTransition slideOut(AnchorPane node, int time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setNode(node);
        slide.setDuration(Duration.seconds(time));
        slide.fromXProperty();
        slide.setToX(-node.getWidth() / 1.3);
        slide.toXProperty();
        return slide;
    }

    /**
     * Slides in a node back to its original position.
     *
     * @param node - Node to animate
     * @param time - Duration of animation
     * @return :TranslateTransition object
     */
    public TranslateTransition slideIn(AnchorPane node, int time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setNode(node);
        slide.setDuration(Duration.seconds(time));
        slide.fromXProperty();
        slide.setToX(0);
        slide.toXProperty();
        return slide;
    }
}

