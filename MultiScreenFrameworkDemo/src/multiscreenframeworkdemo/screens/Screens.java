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
package multiscreenframeworkdemo.screens;

/**
 *
 * @author Karanja <admin.dev@gmail.com>
 *
 * All the screens MUST be defined in this Singleton class.
 *
 */
public class Screens {

    private static final Screens INSTANCE = new Screens();

    private Screens() {
    }

    public static Screens getInstance() {
        return INSTANCE;
    }

    // Define all the screens/containers here
    // Give a descriptive screen name
    public String SCREEN_1_NAME = "screen_001";
    public String SCREEN_2_NAME = "screen_002";
    public String SCREEN_3_NAME = "screen_003";

    // Define the package where your view files are located
    public String PACKAGE_VIEW = "/multiscreenframeworkdemo/views/";

    // The actual screen/ui .fxml
    public String SCREEN_1_FXML = "screen_001.fxml";
    public String SCREEN_2_FXML = "screen_002.fxml";
    public String SCREEN_3_FXML = "screen_003.fxml";

}
