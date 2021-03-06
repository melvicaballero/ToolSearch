/*
 * @(#) Asset.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.search.asset;

/**
 * Asset class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class Asset {

    /** Save Path valid for Asset. */
    private String path;

    /** Save filename valid for Asset. */
    private String fileName;

    /** Save extension valid for Asset. */
    private String extension;

    /** Save hidden valid for Asset. */
    private boolean hidden;

    /** Save owner valid for Asset. */
    private String owner;

    /** Save size valid for Asset. */
    private String size;

    /** Save readOnly valid for Asset. */
    private boolean readOnly;

    /** Save creationDate valid for Asset. */
    private String creationDate;

    /** Save modificationDate valid for Asset. */
    private String modificationDate;

    /** Save lastDate valid for Asset. */
    private String lastDate;

    /** Save isDirectory valid for Asset. */
    private boolean isDirectory;

    /**
     * Constructor Asset class.
     */
    public void Asset() {
        path = "";
        fileName = "";
        extension = "";
        hidden = false;
        owner = "";
        size = "";
        readOnly = false;
        creationDate = "";
        modificationDate = "";
        lastDate = "";
        isDirectory = false;
    }

    /**
     * @return path get path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path set path file.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return fileName get file name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName set file name file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return extension get extension file.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension set extension file as String value.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return hidden for the file, that is a boolean value.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden set hidden boolean value.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return owner get file.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner set owner file.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return size get size of the file.
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size as String value set size file.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return readOnly set read only file a property of file.
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly as boolean value set read only file.
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return creationDate get creation date property of file.
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate as String set creation date.
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return modificationDate get modification date property of file.
     */
    public String getModificationDate() {
        return modificationDate;
    }

    /**
     * @param modificationDate as String set modification date.
     */
    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * @return lastDate get this property of file.
     */
    public String getLastDate() {
        return lastDate;
    }

    /**
     * @param lastDate as String set last date.
     */
    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    /**
     * @return isDirectory as boolean value.
     */
    public boolean isDirectory() {
        return isDirectory;
    }

    /**
     * @param directory as boolean value for know if the file is directory.
     */
    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }
}
