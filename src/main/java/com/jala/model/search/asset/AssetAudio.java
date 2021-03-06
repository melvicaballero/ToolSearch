/*
 * @(#) AssetAudio.java Copyright (c) 2019 Jala Foundation.
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
 * AssetAudio class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetAudio extends Asset {

    /** Save AudioCodec valid for AssetAudio. */
    private String audioCodec;

    /** Save channel valid for AssetAudio. */
    private String channel;

    /** Save audioSampleRate valid for AssetAudio. */
    private String audioSampleRate;

    /** Save duration valid for AssetAudio. */
    private String duration;

    /**
     * Constructor of AssetAudio class.
     */
    public void AssetAudio() {
        audioCodec = "";
        channel = "";
        audioSampleRate = "";
        duration = "";
    }

    /**
     * Return the audio codec value.
     * @return audioCodec return as a String value.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Set the audio codec attribute of audio.
     * @param audioCodec this is an attribute of audio for the advanced searched.
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Return the frame rate value.
     * @return channel return as a String value.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Set the channel attribute of audio.
     * @param channel this is an attribute of audio for the advanced searched.
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Return the frame rate value.
     * @return audioSampleRate return as a String value.
     */
    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * Set the audio sample rate of attribute of audio.
     * @param audioSampleRate this is an attribute of audio for the advanced searched.
     */
    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    /**
     * Return the frame rate value.
     * @return duration return as a int value.
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Set the duration attribute of audio.
     * @param duration this is an attribute of audio for the advanced searched.
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
