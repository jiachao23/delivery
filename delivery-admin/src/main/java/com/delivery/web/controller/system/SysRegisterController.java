package com.delivery.web.controller.system;

import com.delivery.common.core.controller.BaseController;
import com.delivery.common.core.domain.AjaxResult;
import com.delivery.framework.shiro.service.SysRegisterService;
import com.delivery.system.domain.SysUser;
import com.delivery.system.service.ISysConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册验证
 * @author jiac
 */
@Controller
public class SysRegisterController extends BaseController {
	@Autowired
	private SysRegisterService registerService;

	@Autowired
	private ISysConfigService configService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	@ResponseBody
	public AjaxResult ajaxRegister(SysUser user) {
		if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
			return error("当前系统没有开启注册功能！");
		}
		String msg = registerService.register(user);
		return StringUtils.isEmpty(msg) ? success() : error(msg);
	}
}
