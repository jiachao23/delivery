package com.delivery.utils;

import com.delivery.common.utils.uuid.IdUtils;
import org.junit.jupiter.api.Test;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/9/17:17:25
 * @since 1.0.0
 */
public class NumberTest {

	@Test
	public void testGeneratorNUmber() {
		for (int i = 0; i < 100; i++) {
			System.out.println(IdUtils.generateNumber(12));
		}
	}
}
