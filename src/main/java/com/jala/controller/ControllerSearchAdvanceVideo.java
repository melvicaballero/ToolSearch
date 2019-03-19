/*
 * @(#) ControllerSearchAdvanceVideo.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.jala.controller;

import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.criteria.CriteriaSearchMultimedia;
import com.jala.model.search.SearchFile;
import com.jala.model.search.SearchVideo;
import com.jala.model.search.asset.Asset;
import com.jala.utils.Logs;
import com.jala.view.JPanelSearchAdvancedVideo;
import com.jala.view.JPanelSearchVideo;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * ControllerSearchAdvanceVideo class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ControllerSearchAdvanceVideo extends ControllerSearchAdvanced implements ActionListener{

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    /** Criteria for manages an instance of JPanelSearchAdvancedVideo */
    private JPanelSearchAdvancedVideo viewAdvancedVideo;

    /** This is temporal, it is just for calculate a size of the file.*/
    private final static double BYTES = 1024.0;

    /** To save the values of the UI and send to SearchFile*/
    private CriteriaSearchMultimedia criteriaSearchMultimedia;

    /**
     * ControllerSearchAdvanceVideo is the constructor method,
     * for create an instance of this class.
     * @param viewAdvanced has a data of GUI.
     */
    public ControllerSearchAdvanceVideo(JPanelSearchAdvancedVideo viewAdvanced) {
        log.info("Initialize the Control of Video Advanced Search.");
        //super();
        this.viewAdvancedVideo = viewAdvanced;
        actionListener();
    }

    /**
     * Initialize the action listener of the btnSearch button.
     */
    private void actionListener() {
        log.info("It will add action listener for the button in Video Advanced Search.");
        viewAdvancedVideo.getPanelSearchVideo().getBtnSearch().addActionListener(this);
        log.info("It was end  action listener for the button in Video Advanced Search.");
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed.
     * @param event this activates when a button is  pressed
     *
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        log.info("It was detected an event on the JPanelSearchAdvancedVideo class ");
        Object source = event.getSource();
        if (source == viewAdvancedVideo.getPanelSearchVideo().getBtnSearch()) {
            CriteriaSearch criteriaSearch = super.getCriteria(viewAdvancedVideo.getPanelAdvanceSearch());
            this.criteriaSearchMultimedia = new CriteriaSearchMultimedia(criteriaSearch);
            addAttibutesOfVideo();
            System.out.println("Values: " + criteriaSearchMultimedia.getAspectRatio());
            sendCriteriaToFile(criteriaSearchMultimedia);
        }
    }

    /**
     * Send criteriaSearch to SearchFile to search files like the filename or extension,
     * receive a list of results, and print the results in the UI table.
     * @param criteria has data for search video file
     */
    private void sendCriteriaToFile(CriteriaSearch criteria) {
        log.info("Preparing to send criteria to SearchFile");
        SearchVideo searchFile = new SearchVideo(criteriaSearchMultimedia);
        List<Asset> results = searchFile.search(criteria);
        log.info("Information sending and waiting answers");
        viewAdvancedVideo.getTblResult().removeRow();
        for (int i = 0; i < results.size(); i++) {
            Asset data = results.get(i);
            viewAdvancedVideo.getTblResult().addResultRow(Integer.toString(i), data.getPath(), data.getFileName(),
                    data.getExtension(), super.getFileSizeInKb(data.getSize()));
        }
        log.info("Results implemented in the JTable of the UI");
    }

    /**
     * Without comments...................
     *
     */
    private void addAttibutesOfVideo() {
        JPanelSearchVideo searchVideo = viewAdvancedVideo.getPanelSearchVideo();
        this.criteriaSearchMultimedia.setAspectRatio(searchVideo.getCmbAspectRatio());
        this.criteriaSearchMultimedia.setAudioCodec(searchVideo.getCmbAudioCodec());
        this.criteriaSearchMultimedia.setDimension(searchVideo.getCmbDimension());
        this.criteriaSearchMultimedia.setExtension(searchVideo.getCmbExtension());
        this.criteriaSearchMultimedia.setFrameRate(searchVideo.getCmbFrameRate());
        this.criteriaSearchMultimedia.setVideoCodec(searchVideo.getCmbVideoCodec());
    }

    /**
     * @return the CriteriaSearchMultimedia attribute of this class.
     */
    public CriteriaSearchMultimedia getCriteriaSearch() {
        return criteriaSearchMultimedia;
    }
}
