package com.delivery.common.constant;

/**
 * 通用常量信息
 *
 * @author jiac
 */
public class Constants {
	/**
	 * UTF-8 字符集
	 */
	public static final String UTF8 = "UTF-8";

	/**
	 * GBK 字符集
	 */
	public static final String GBK = "GBK";

	/**
	 * GBK 字符集
	 */
	public static final String DELIMITER = "|";

	/**
	 * 通用成功标识
	 */
	public static final String SUCCESS = "0";

	/**
	 * 通用失败标识
	 */
	public static final String FAIL = "1";

	/**
	 * 登录成功
	 */
	public static final String LOGIN_SUCCESS = "Success";

	/**
	 * 注销
	 */
	public static final String LOGOUT = "Logout";

	/**
	 * 注册
	 */
	public static final String REGISTER = "Register";

	/**
	 * 登录失败
	 */
	public static final String LOGIN_FAIL = "Error";

	/**
	 * 当前记录起始索引
	 */
	public static final String PAGE_NUM = "pageNum";

	/**
	 * 每页显示记录数
	 */
	public static final String PAGE_SIZE = "pageSize";

	/**
	 * 排序列
	 */
	public static final String ORDER_BY_COLUMN = "orderByColumn";

	/**
	 * 排序的方向 "desc" 或者 "asc".
	 */
	public static final String IS_ASC = "isAsc";

	/**
	 * 参数管理 cache name
	 */
	public static final String SYS_CONFIG_CACHE = "sys-config";

	/**
	 * 参数管理 cache key
	 */
	public static final String SYS_CONFIG_KEY = "sys_config:";

	/**
	 * 字典管理 cache name
	 */
	public static final String SYS_DICT_CACHE = "sys-dict";

	/**
	 * 分类管理 cache name
	 */
	public static final String SYS_CATEGORY_CACHE = "sys-category";

	/**
	 * 字典管理 cache key
	 */
	public static final String SYS_DICT_KEY = "sys_dict:";

	/**
	 * 资源映射路径 前缀
	 */
	public static final String RESOURCE_PREFIX = "/profile";

	/**
	 * 上传传输交易码，该字段内容请向文件传输平台管理员申请；
	 */
	public static final String PUT_TRANSCODE = "100044";

	/**
	 * 下载传输交易码，该字段内容请向文件传输平台管理员申请；
	 */
	public static final String GET_TRANSCODE = "100021";

	/**
	 * 取值 0:不处理 1:加密 2:压缩 3:加密且压缩,应用系统根据文件传输需求进行选择；
	 */
	public static final int CFG = 0;

	/**
	 * UID
	 */
	public static final String UID = "delivery";

	/**
	 * UID
	 */
	public static final String FMSUID = "fms";
}
