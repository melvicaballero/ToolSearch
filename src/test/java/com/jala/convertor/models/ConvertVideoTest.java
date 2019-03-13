/*
 * @(#) ConvertVideoTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.convertor.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertVideoTest {
	private String path = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos\\Marvel.mp4";
	private String pathDestination = "C:\\Users\\Admin\\Desktop\\PROG 02\\Videos";

	/**
	 * Convert MP4 to FLV basic
	 */
	@Test
	public void convert_ReturnFlvFile_WhenSentBasicMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".flv");
		criteria.setFileName("marvelita");
		try {
			convert.convert(criteria);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Convert MP4 to FLV basic
	 */
	@Test
	public void convert_ReturnFlvFile_WhenSentAdvancedSentMP4File() {

		ConvertVideo convert = new ConvertVideo();
		CriteriaConverterVideo criteria = new CriteriaConverterVideo(path,pathDestination + "\\",".flv");
		criteria.setNewFileName("mAdvanced");
		criteria.setIsAdvanced(true);
		criteria.setAudioChannel("Mono");
		try {
			convert.convert(criteria);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}