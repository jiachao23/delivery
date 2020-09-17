package com.delivery.common.utils.uuid;

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
	 * 生成随机的字符串文件名 随机6位字符串
	 * @return /
	 */
	public static String generateCharacter(int length) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int intVal = (int) (Math.random() * 26 + 97);
			result.append((char) intVal);
		}
		return result.toString();
	}

	/**
	 * 生成随机的字符串文件名 随机6位字符串
	 * @return /
	 */
	public static String generateNumber(int length) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int intVal = (int) (Math.random() * 10 + 48);
			result.append((char) intVal);
		}
		return result.toString();
	}
}
