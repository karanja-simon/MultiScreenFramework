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
package com.zilabs.multiscreenframework.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @version 2.0.1
 * @author S.Karanja <dev.zilabs@gmail.com>
 *
 * This class loads the framework info and tutorials on how to use the
 * framework.
 */
public class Info {

    private static final StringBuilder sb = new StringBuilder();
    private final static String FRAMEWORK_VERSION = "2.0.1";

    /**
     * Gets the framework change log as a formatted string.
     *
     * @return - The change log as string to be printed to console via
     * System.out.print()
     */
    public static String getFrameworkChangeLog() {
        try {
            InputStream is = Info.class.getClass().getResourceAsStream("/screenframework/com/zilabs/frameworkinfo/changelog");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            sb.setLength(0);
            while (br.read() > 1) {
                sb.append(br.readLine());
                sb.append("\n");
            }
        } catch (IOException e) {
            return e.getMessage();
        }
        return sb.toString();
    }

    /**
     * Gets the framework usage as a formatted string.
     *
     * @return - The framework usage as string to be printed to console via
     * System.out.print()
     */
    public static String getFrameworkUsage() {
        try {
            InputStream is = Info.class.getClass().getResourceAsStream("/screenframework/com/zilabs/frameworkinfo/usage");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            sb.setLength(0);
            while (br.read() > 1) {
                sb.append(br.readLine());
                sb.append("\n");
            }
        } catch (IOException e) {
            return e.getMessage();
        }
        return sb.toString();
    }

    /**
     * Gets the framework version as a formatted string.
     *
     * @return - The framework version as string to be printed to console via
     *           System.out.print()
     */
    public static String getFrameworkVersion() {
        return FRAMEWORK_VERSION;
    }

    public static String getFrameworkInfo() {
        sb.setLength(0);
        sb.append("MultiScreenFramework 2.0.1");
        sb.append("\n");
        sb.append("(C) 2017 ZiLabs");
        sb.append("\n");
        sb.append("http://zilabs.pe.u");
        sb.append("\n");
        return sb.toString();
    }

}
