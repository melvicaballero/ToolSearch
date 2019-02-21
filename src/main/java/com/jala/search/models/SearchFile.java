/**
 * @(#)SearchFile.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SearchFile class
 * @version 0.0.1
 * @author Areliez Vargas
 */
public class SearchFile implements ISearchable {

    /**
     * This method return a file list by attributes of criteria.
     * @param criteria to do the search with the path is required and other attributes are optional.
     * @return a list of the files that content the folder set in the path of criteria.
     */
    @Override
    public List<File> search(CriteriaSearch criteria) {
        File folder = new File(criteria.getPath());
        List<File> files = new ArrayList<>();
        if (folder.exists()) {
            File[] findFiles = folder.listFiles();
            files = Arrays.asList(findFiles);
        }
        return files;
    }
}