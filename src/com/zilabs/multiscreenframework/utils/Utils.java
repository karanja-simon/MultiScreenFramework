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
package com.zilabs.multiscreenframework.utils;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @version 2.0.1
 * @author S.Karanja <dev.zilabs@gmail.com>
 *
 * This class holds all utility methods for this framework.
 */
public class Utils {

    /**
     * This method allow the AnchorPane to stretch 100% of the application's
     * viewport, if allow is set to true, otherwise the AnchorPane will use it's
     * preferred size.
     * If you need your UI to to scale with the display area, then you must pass
     * true as the first parameter to this method.
     *
     * @param allow - True, to allow stretch, false otherwise
     * @param node     - The Node to stretch.
     */
    public static void allowStrech(boolean allow, Node node) {
        if (allow) {
            AnchorPane.setTopAnchor(node, Double.valueOf(0));
            AnchorPane.setLeftAnchor(node, Double.valueOf(0));
            AnchorPane.setRightAnchor(node, Double.valueOf(0));
            AnchorPane.setBottomAnchor(node, Double.valueOf(0));
        }
    }
}
