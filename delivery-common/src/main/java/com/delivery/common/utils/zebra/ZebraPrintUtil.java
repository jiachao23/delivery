package com.delivery.common.utils.zebra;

import java.io.UnsupportedEncodingException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.standard.PrinterName;

import com.delivery.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description: Zebra打印机
 *
 * @author liufeng
 * @version 2020/8/24 10:47
 * @since v1.0.0
 */
public class ZebraPrintUtil {
	private final static Logger log = LoggerFactory.getLogger(ZebraPrintUtil.class);

	private static String printerURI = null;//打印机完整路径

	private static PrintService printService = null;//打印机服务

	//GB18030 ^CW1,E:SIMSUN.FNT  ARLRDBD.TTF SIMHEI
	private static String begin = "^XA^SEE:GB18030.DAT^CWZ,E:SIMSUN.FNT^LH10,10"; //标签格式以^XA开始

	private static String end = "^XZ"; //标签格式以^XZ结束

	private static String content = "";

	private static int cnCharSize = 30;//中文字体大小？ 25

	private static int charSize = 26;//英文字体高度？

	private static int charSep = 15;//英文字体大小？

	private static int lineSep = 10;//行间距？

	//打印纸宽度 x
	private static int width = 500;

	//打印纸高度 y
	//小纸张
	private static int height = 400;

	//  private int height = 750;
	private static int labelLength = 4 * cnCharSize;

	//label的起始位置
	private static int labelX = 8;

	private static int labelY = 10;

	//条形码起始的x
	private static int bqx = 20;

	//条形码起始的y
	private static int bqy = height / 2 + 50;

	//底部内容起始的x
	private static int bottomX = bqx - 30;

	//底部内容起始的y
	private static int bottomY = 20;

	/**
	 * 执行打印
	 * @param message 标签信息
	 */
	public static void execute(LabelMessage message) {
		init("ZDesigner GT800 (ZPL)");
		// F0 x坐标，y坐标
		//BQ 二维码
//        String qrcode_t = "^FO%s,%s^BY3^B1N,N,100,Y,N^CI0^FD${data}^FS";
		String qrcode_t = "^FO%s,%s^BY3^BCN,100,Y,N,Y,A^FD${data}^FS";
		qrcode_t = String.format(qrcode_t, bqx, bqy);//二维码位置
		setBarcode(message.getNumber(), qrcode_t);//设置二维码的内容
		//FW控制字体方向   N   R  I  B  和setCharR中的A0R的R，A1R的R
		content += "^FWN";
		int[] xy = new int[] { labelX, labelY };
		//起始   100，50

		xy = setLabelTitle(xy, "陕西省农村信用社联合社");
		xy = setLabelValue(xy, "资产编号：", message.getNumber());
		xy = setLabelValue(xy, "资产名称：", message.getName());
		xy = setLabelValue(xy, "设备型号：", message.getType());
		xy = setLabelValue(xy, "启用时间：", DateUtils.parseDateToStr("yyyy-MM-dd", message.getStartTime()));
		xy = setLabelValueNoWrapLine(xy, "领用人：", message.getOwnerName());
		xy = setLabelValue(xy, "存放地点：", message.getAddress());
		xy = setLabelValue(xy, "使用部门：", message.getDepartment());
		content += "^CI0^PQ1";//打印1张

		String zpl2 = getZpl();
		log.info("zpl: " + zpl2);
		print(zpl2);
		//清空标签内容
		content = "";
	}

	/**
	 * 设置标签公司名
	 *
	 * @param xy
	 * @param company
	 * @return
	 */
	private static int[] setLabelTitle(int[] xy, String company) {
		xy[0] = labelX;
		xy = setTitle(company, xy);
		xy[1] += cnCharSize + lineSep * 3;
		return xy;
	}

	/**
	 * 设置标签单行文本
	 * @param xy 坐标
	 * @param label1 字段值
	 * @param value1 属性值
	 * @return 坐标
	 */
	private static int[] setLabelValue(int[] xy, String label1, String value1) {
		xy[0] = labelX;
		xy = setText(label1, xy);
		xy[0] = labelX + labelLength - 10;
		xy = setText(value1, xy);
		xy[1] += cnCharSize;
		return xy;
	}

	/**
	 * 设置不换行标签内容
	 * @param xy
	 * @param label1 字段值
	 * @param value1 属性值
	 * @return 坐标
	 */
	private static int[] setLabelValueNoWrapLine(int[] xy, String label1, String value1) {
		xy[0] = xy[0] + labelLength / 2 - 40;
		xy[1] -= cnCharSize;
		xy = setText(label1, xy);
		xy[0] += labelX - 15;
		xy = setText(value1, xy);
		xy[1] += cnCharSize - 3;
		return xy;
	}

	private static int[] setBottomLabelValue(ZebraPrintUtil p, int[] xy, String label1, String value1) {
		xy[1] = labelY;
		xy = p.setText(label1, xy);
		xy[1] = labelY + 180;
		xy = p.setText(value1, xy);
		xy[0] += cnCharSize + lineSep;
		return xy;
	}

	/**
	 * 构造方法
	 *
	 * @param url 打印机路径
	 */
	private static void init(String url) {
		printerURI = url;
		PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
		if (services != null && services.length > 0) {
			for (PrintService service : services) {
				if (printerURI.equals(service.getName())) {
					printService = service;
					break;
				}
			}
		}
		if (printService == null) {
			log.info("没有找到打印机：[" + printerURI + "]");
			//循环出所有的打印机
			if (services != null && services.length > 0) {
				log.info("可用的打印机列表：");
				for (PrintService service : services) {
					log.info("[" + service.getName() + "]");
				}
			}
		}
		else {
			log.info("找到打印机：[" + printerURI + "]");
			log.info("打印机名称：[" + printService.getAttribute(PrinterName.class).getValue() + "]");
		}
	}

	/**
	 * 设置条形码
	 *
	 * @param barcode 条码字符
	 * @param zpl     条码样式模板
	 */
	private static void setBarcode(String barcode, String zpl) {
		content += zpl.replace("${data}", barcode);
	}

	/**
	 * 检查文字是中文还是英文
	 * @param ch 文字
	 * @return true 表示英文，false表示中文
	 */
	private static boolean checkChar(char ch) {
		if ((ch + "").getBytes().length == 1) {
			return true;//英文
		}
		else {
			return false;//中文
		}
	}

	/**
	 * 设置标签具体内容
	 * @param str 文本
	 * @param xy 坐标
	 * @return 坐标
	 */
	private static int[] setText(String str, int[] xy) {
		int x = xy[0];
		int y = xy[1];
		if (str != null) {
			char[] charArray = str.toCharArray();
			int initX = x;
			for (int off = 0; off < charArray.length; ) {
				char c = charArray[off];
				if (!checkChar(c)) {//判断中英文  英true  中false
					setCharR(String.valueOf(c), x, y, true);
					x = x + cnCharSize - 5;
				}
				else {
					setCharR(String.valueOf(c), x, y, false);
					x = x + charSep;
				}

				if (x >= width + 180) {
					x = initX;
					y -= charSize + lineSep;
				}
				off++;
			}
		}

		return new int[] { x, y };
	}

	/**
	 * 设置标签title
	 * @param str 文本
	 * @param xy 坐标
	 * @return 坐标
	 */
	private static int[] setTitle(String str, int[] xy) {
		int titleCharSize = 40;
		int x = xy[0];
		int y = xy[1];
		if (str != null) {
			char[] charArray = str.toCharArray();
			int initX = x;
			for (int off = 0; off < charArray.length; ) {
				char c = charArray[off];
				if (!checkChar(c)) {//判断中英文  英true  中false
					setChar(String.valueOf(c), x, y, true, titleCharSize);
					x = x + titleCharSize;
				}
				else {
					setChar(String.valueOf(c), x, y, false, titleCharSize);
					x = x + charSep;
				}

				if (x >= width + 180) {
					x = initX;
					y -= charSize + lineSep;
				}
				off++;
			}
		}

		return new int[] { x, y };
	}

	/**
	 * 字符串(包含数字)
	 *
	 * @param str 字符串
	 * @param x   x坐标
	 * @param y   y坐标
	 * @param h   高度
	 * @param w   宽度
	 */
	private static void setChar(String str, int x, int y, int h, int w) {
		content += "^FO" + x + "," + y + "^A0," + h + "," + w + "^FD" + str + "^FS";
	}

	/**
	 * 字符(包含数字)顺时针旋转90度
	 *
	 * @param str 字符串
	 * @param x   x坐标
	 * @param y   y坐标
	 * @param cn  是否为中文
	 */
	private static void setCharR(String str, int x, int y, boolean cn) {
		if (cn) {
			//中文
			content += "^CI14";
			content += "^FO" + x + "," + y + "^AZN," + cnCharSize + "," + cnCharSize + "^FD" + str + "^FS";
		}
		else {
			content += "^CI0";
			content += "^FO" + x + "," + y + "^AZN," + charSize + "," + charSize + "^FD" + str + "^FS";
		}

	}

	/**
	 * 设置单个字符样式
	 * @param str 文本
	 * @param x 坐标x
	 * @param y 坐标y
	 * @param cn 是否中文， true中文，false英文
	 * @param charSize 字符大小
	 */
	private static void setChar(String str, int x, int y, boolean cn, int charSize) {
		if (cn) {
			//中文
			content += "^CI14";
			content += "^FO" + x + "," + y + "^AZN," + charSize + "," + charSize + "^FD" + str + "^FS";
		}
		else {
			content += "^CI0";
			content += "^FO" + x + "," + y + "^AZN," + charSize + "," + charSize + "^FD" + str + "^FS";
		}

	}

	/**
	 * 获取完整的ZPL
	 *
	 * @return 完整标签内容
	 */
	private static String getZpl() {
		return begin + content + end;
	}

	/**
	 * 重置ZPL指令，当需要打印多张纸的时候需要调用。
	 */
	private static void resetZpl() {
		begin = "^XA";
		end = "^XZ";
		content = "";
	}

	/**
	 * 打印
	 *
	 * @param zpl 完整的ZPL
	 */
	private static boolean print(String zpl) {
		if (printService == null) {
			log.info("打印出错：没有找到打印机：[" + printerURI + "]");
			return false;
		}
		DocPrintJob job = printService.createPrintJob();
		byte[] by = null;
		try {
			by = zpl.getBytes("GB18030");
		}
		catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		Doc doc = new SimpleDoc(by, flavor, null);
		try {
			job.print(doc, null);
			log.info("已打印");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
