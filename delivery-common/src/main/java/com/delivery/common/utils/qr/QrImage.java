package com.delivery.common.utils.qr;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/18:17:34
 * @since 1.0.0
 */
public class QrImage {
	/**
	 * 二维码的内容(非空)
	 */
	private String qrCodeContent;

	/**
	 * 二维码的宽度(非空)
	 */
	private Integer qrCodeWidth;

	/**
	 * 二维码的高度(非空)
	 */
	private Integer qrCodeHeight;

	/**
	 * 二维码内嵌图片的文件路径(为空则表示:二维码中间不嵌套图片)
	 */
	private String embeddedImgFilePath;

	/**
	 * 文字的大小(即:正方形文字的长度、宽度)(非空)
	 */
	private Integer wordSize;

	/**
	 * 文字的内容(非空)
	 */
	private String wordContent;

	/**
	 * 二维码文件的输出路径(非空)
	 */
	private String qrCodeFileOutputPath;


	public String getQrCodeContent() {
		return qrCodeContent;
	}

	public void setQrCodeContent(String qrCodeContent) {
		this.qrCodeContent = qrCodeContent;
	}

	public Integer getQrCodeWidth() {
		return qrCodeWidth;
	}

	public void setQrCodeWidth(Integer qrCodeWidth) {
		this.qrCodeWidth = qrCodeWidth;
	}

	public Integer getQrCodeHeight() {
		return qrCodeHeight;
	}

	public void setQrCodeHeight(Integer qrCodeHeight) {
		this.qrCodeHeight = qrCodeHeight;
	}

	public String getEmbeddedImgFilePath() {
		return embeddedImgFilePath;
	}

	public void setEmbeddedImgFilePath(String embeddedImgFilePath) {
		this.embeddedImgFilePath = embeddedImgFilePath;
	}

	public Integer getWordSize() {
		return wordSize;
	}

	public void setWordSize(Integer wordSize) {
		this.wordSize = wordSize;
	}

	public String getWordContent() {
		return wordContent;
	}

	public void setWordContent(String wordContent) {
		this.wordContent = wordContent;
	}

	public String getQrCodeFileOutputPath() {
		return qrCodeFileOutputPath;
	}

	public void setQrCodeFileOutputPath(String qrCodeFileOutputPath) {
		this.qrCodeFileOutputPath = qrCodeFileOutputPath;
	}
}
