package com.delivery.common.utils.uuid;

import com.delivery.common.enums.AssertType;
import com.delivery.common.utils.DateUtils;

/**
 * ID生成器工具类
 *
 * @author jiac
 */
public class IdUtils {
	/**
	 * 获取随机UUID
	 *
	 * @return 随机UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 简化的UUID，去掉了横线
	 *
	 * @return 简化的UUID，去掉了横线
	 */
	public static String simpleUUID() {
		return UUID.randomUUID().toString(true);
	}

	/**
	 * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
	 *
	 * @return 随机UUID
	 */
	public static String fastUUID() {
		return UUID.fastUUID().toString();
	}

	/**
	 * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
	 *
	 * @return 简化的UUID，去掉了横线
	 */
	public static String fastSimpleUUID() {
		return UUID.fastUUID().toString(true);
	}

	/**
	 * 获取固定资产文件名
	 * @return /
	 */
	public static String getFixedFileName() {
		return "cwgdzcsj_" + DateUtils.getDate().replaceAll("-", "") + ".txt";
	}

	/**
	 * 获取固定资产文件名
	 * @return /
	 */
	public static String getJsonFileName() {
		return DateUtils.getDate().replaceAll("-", "") + ".json";
	}

	/**
	 * 获取低值易耗品文件名
	 * @return /
	 */
	public static String getConsumableFileName() {
		return "cwdzyhpsj_" + DateUtils.getDate().replaceAll("-", "") + ".txt";
	}

	/**
	 * 获取文件名
	 * @param assertType AssertType
	 * @return /
	 */
	public static String getFileName(AssertType assertType) {
		if (assertType == AssertType.FIXED) {
			return getFixedFileName();
		}
		else if (assertType == AssertType.CONSUMABLE) {
			return generatorConsumableFileName();
		}
		return null;
	}

	/**
	 * 生成固定资产文件名
	 * @return /
	 */
	public static String generatorFixedFileName() {
		return "zggdzcsj_" + DateUtils.getDate().replaceAll("-", "") + ".txt";
	}

	/**
	 * 生成地址易耗品文件名
	 * @return /
	 */
	public static String generatorConsumableFileName() {
		return "zgdzyhpsj_" + DateUtils.getDate().replaceAll("-", "") + ".txt";
	}

	public static String generatorFileName(AssertType assertType) {
		if (assertType == AssertType.FIXED) {
			return generatorFixedFileName();
		}
		else if (assertType == AssertType.CONSUMABLE) {
			return generatorConsumableFileName();
		}
		return null;
	}
}
