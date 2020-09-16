package com.delivery.common.exception.user;

import com.delivery.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * @author jiac
 */
public class UserException extends BaseException {
	private static final long serialVersionUID = 1L;

	public UserException(String code, Object[] args) {
		super("user", code, args, null);
	}
}
