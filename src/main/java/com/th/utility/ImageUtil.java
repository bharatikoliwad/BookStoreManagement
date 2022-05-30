package com.th.utility;

import java.util.Base64;

/**
 * converts byte[] of an image to String
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */
public class ImageUtil {
	/**
	 * converts byte[] of an image to String using Base64 encoder
	 * 
	 * @param byteData
	 * @return String
	 */
	public String getImgData(byte[] byteData) {
		return Base64.getMimeEncoder().encodeToString(byteData);

	}

}
