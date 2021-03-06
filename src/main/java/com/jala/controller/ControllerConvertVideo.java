/*
 * @(#) ControllerConvertVideo.java Copyright (c) 2019 Jala Foundation.
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

import com.jala.model.convert.ConvertAudio;
import com.jala.model.convert.ConvertVideo;
import com.jala.model.criteria.CriteriaConverterAudio;
import com.jala.model.criteria.CriteriaConverterVideo;
import com.jala.utils.Logs;
import com.jala.view.CustomErrorMessage;
import com.jala.view.JPanelConverterVideo;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class Controller of Convert a Video and audio.
 * @version: 0.0.1
 * @autor: Melvi Caballero M.
 */
public class ControllerConvertVideo implements ActionListener {

    /** It creates to follow up the instruction of the class.*/
    private Logger log = Logs.getInstance().getLog();

    /** ViewConvert: create a pointer of JPanelConverterVideo the object will provide other class.*/
    private JPanelConverterVideo viewConvert;

    /** Criteria for convert video.*/
    private CriteriaConverterVideo criteriaConverterVideo;

    /** Criteria for convert audio.*/
    private CriteriaConverterAudio criteriaConverterAudio;

    /**
     * This constructor of class.
     * @param viewConvert object of UI Panel for convert video and audio.
     */
    public ControllerConvertVideo(JPanelConverterVideo viewConvert) {
        log.info("Initialize the Control of Search General");
        this.viewConvert = viewConvert;
        log.info("Initialize the adding of listener for the buttons in Convert General");
        viewConvert.getBtnConvertVideo().addActionListener(this);
        log.info("Finish the actionListener");
    }

    /**
     * It is override the method of ActionListener and the objective is listen if button is pressed.
     * @param event this activates when a button is  pressed.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        log.info("Action Detected");
        if (event.getSource() == viewConvert.getBtnConvertVideo()) {
            String error = "The fields: File Origin Path, Folder Output, File Name. Are Required";
            if (viewConvert.isVideo()) {
                log.info("BtnConvert from Search General was pressed");
                if (areRequiredValue()) {
                    sendPathToConvertVideo();
                } else {
                    viewConvert.setMsgError("error");
                }
            } else {
                log.info("BtnConvert from Search General was pressed");
                if (areRequiredValue()) {
                    sendPathToConvertAudio();
                } else {
                    viewConvert.setMsgError(error);
                }
            }
        }
    }

    /**
     * The areRequiredValue method verify whether we have the data required
     * @return true or false
     */
    private boolean areRequiredValue() {
        String path = viewConvert.getTxtPathFileOrigin();
        String output = viewConvert.getTxtFolderDestiny();
        String fileName = viewConvert.getTxtFileName();
        System.out.println("Values: " + path + ", "+ output + ", " + fileName);
        return ((!path.equals(" ")) && (!output.equals("")) && (!fileName.equals("")) ) ? true : false;
    }

    /**
     * This method sends to ConvertVideo the criteria that was wrote by user
     * and that method convert the Video.
     */
    private void sendPathToConvertVideo() {
        log.info("Preparing to send criteria converter to ConvertVideo");
        ConvertVideo converterVideo = new ConvertVideo();
        saveCriteriaVideo();
        converterVideo.convert(criteriaConverterVideo);
    }

    /**
     * This method sends to ConvertAudio the criteria that was wrote by user
     * and that method convert the Audio.
     */
    private void sendPathToConvertAudio() {
        log.info("Preparing to send criteria converter to ConvertAudio");
        ConvertAudio converterAudio = new ConvertAudio();
        saveCriteriaAudio();
        converterAudio.convert(criteriaConverterAudio);
    }

    /**
     * Save the information that the Ui provides into CriteriaConverterVideo to send Converter.
     */
    private void saveCriteriaVideo() {
        String pathOrigin = viewConvert.getTxtPathFileOrigin();
        String pathDestination = viewConvert.getTxtFolderDestiny();
        String fileName = viewConvert.getTxtFileName();
        String extension = viewConvert.getCmbExtensionVideo();
        String resolution = viewConvert.getCmbVideoResolution();
        double frameRate = viewConvert.getCmbFrameRate();
        double bitRate = viewConvert.getCmbBitRate();
        int sampleRate = viewConvert.getCmbSampleRate();
        boolean isAdvanced = viewConvert.isAdvanced();
        String audioChannel = viewConvert.isStereo()? "Stereo" : "Mono";
        criteriaConverterVideo = new CriteriaConverterVideo(pathOrigin, pathDestination + "\\", "." + extension);
        criteriaConverterVideo.setNewFileName(fileName);
        criteriaConverterVideo.setVideoResolution(resolution);
        criteriaConverterVideo.setFrameRate(frameRate);
        criteriaConverterVideo.setBitRate((long)bitRate);
        criteriaConverterVideo.setSampleRate(sampleRate);
        criteriaConverterVideo.setIsAdvanced(isAdvanced);
        criteriaConverterVideo.setAudioChannel(audioChannel);
    }

    /**
     * Save the information that the Ui provides into CriteriaConverterAudio to send Converter.
     */
    private void saveCriteriaAudio() {
        String pathOrigin = viewConvert.getTxtPathFileOrigin();
        String pathDestination = viewConvert.getTxtFolderDestiny();
        String fileName = viewConvert.getTxtFileName();
        String extension = viewConvert.getCmbExtensionAudio();
        double bitRate = viewConvert.getCmbBitRate();
        int sampleRate = viewConvert.getCmbSampleRate();
        String audioChannel = viewConvert.isStereo() ? "Stereo" : "Mono";
        criteriaConverterAudio = new CriteriaConverterAudio(pathOrigin, pathDestination + "\\", "." + extension);
        criteriaConverterAudio.setNewFileName(fileName);
        criteriaConverterAudio.setBitRate((long)bitRate);
        criteriaConverterAudio.setSampleRate(sampleRate);
        criteriaConverterAudio.setAudioChannel(audioChannel);
    }
}
