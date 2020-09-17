package com.delivery.web.controller.system;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import com.delivery.common.config.Global;
import com.delivery.common.core.controller.BaseController;
import com.delivery.framework.util.ShiroUtils;
import com.delivery.system.domain.SysMenu;
import com.delivery.system.domain.SysUser;
import com.delivery.system.service.ISysConfigService;
import com.delivery.system.service.ISysMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页 业务处理
 * @author jiac
 */
@Controller
public class SysIndexController extends BaseController {
	//格式化小数
	DecimalFormat df = new DecimalFormat("0.00");

	@Autowired
	private ISysMenuService menuService;

	@Autowired
	private ISysConfigService configService;

	// 系统首页
	@GetMapping("/index")
	public String index(ModelMap mmap) {
		// 取身份信息
		SysUser user = ShiroUtils.getSysUser();
		// 根据用户id取出菜单
		List<SysMenu> menus = menuService.selectMenusByUser(user);

		mmap.put("menus", menus);
		mmap.put("user", user);
		mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
		mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
		mmap.put("copyrightYear", Global.getCopyrightYear());
		mmap.put("demoEnabled", Global.isDemoEnabled());
		return "index";
	}

	// 切换主题
	@GetMapping("/system/switchSkin")
	public String switchSkin(ModelMap mmap) {
		return "skin";
	}

	// 系统介绍
	@GetMapping("/system/main")
	public String main(ModelMap mmap) {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		mmap.put("year", year);
		mmap.put("month", month);
		mmap.put("version", Global.getVersion());
		return "main";
	}
}
