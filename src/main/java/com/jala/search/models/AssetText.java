/*
 * @(#) AssetText.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;

import java.io.File;

/**
 * AssetText class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetText extends Asset implements IAsset {
    private String contain;

    /**
     * @return contain of a file.
     */
    public String getContain() {
        return contain;
    }

    /**
     * @param contain as String  for search in the file text.
     */
    public void setContain(String contain) {
        this.contain = contain;
    }

    /**
     * The File class is an abstract representation of file and directory
     * pathnames and properties file.
     * @param file as File.
     */
    public void loadFile(File file) {
        super.loadFile(file);
        //TODO load the text properties file.
    }
}
