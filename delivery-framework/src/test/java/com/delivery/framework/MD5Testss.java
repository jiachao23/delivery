package com.delivery.framework;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/3:10:57
 * @since 1.0.0
 */
public class MD5Testss {

	@Test
	public void testMD5() {
		String tongchuan001 = new Md5Hash("tongchuan001" + "123456" + "111111").toHex();
		String baoji001 = new Md5Hash("baoji001" + "123456" + "111111").toHex();
		String xianyang001 = new Md5Hash("xianyang001" + "123456" + "111111").toHex();
		String weinan001 = new Md5Hash("weinan001" + "123456" + "111111").toHex();
		String hanzhong001 = new Md5Hash("hanzhong001" + "123456" + "111111").toHex();
		String ankang001 = new Md5Hash("ankang001" + "123456" + "111111").toHex();
		String shangluo001 = new Md5Hash("shangluo001" + "123456" + "111111").toHex();
		String yanan001 = new Md5Hash("yanan001" + "123456" + "111111").toHex();
		String yulin001 = new Md5Hash("yulin001" + "123456" + "111111").toHex();
		System.out.println("tongchuan001 -----" + tongchuan001);
		System.out.println("baoji001 -----" + baoji001);
		System.out.println("xianyang001 -----" + xianyang001);
		System.out.println("weinan001 -----" + weinan001);
		System.out.println("hanzhong001 -----" + hanzhong001);
		System.out.println("ankang001 -----" + ankang001);
		System.out.println("shangluo001 -----" + shangluo001);
		System.out.println("yanan001 -----" + yanan001);
		System.out.println("yulin001 -----" + yulin001);

	}
}
