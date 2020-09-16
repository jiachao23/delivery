package com.delivery.web.controller.monitor;

import java.util.List;

import com.delivery.common.annotation.Log;
import com.delivery.common.core.controller.BaseController;
import com.delivery.common.core.domain.AjaxResult;
import com.delivery.common.core.page.TableDataInfo;
import com.delivery.common.enums.BusinessType;
import com.delivery.common.utils.poi.ExcelUtil;
import com.delivery.framework.shiro.service.SysPasswordService;
import com.delivery.system.domain.SysLogininfor;
import com.delivery.system.service.ISysLogininforService;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统访问记录
 * @author jiac
 */
@Controller
@RequestMapping("/monitor/logininfor")
public class SysLogininforController extends BaseController {
	private String prefix = "monitor/logininfor";

	@Autowired
	private ISysLogininforService logininforService;

	@Autowired
	private SysPasswordService passwordService;

	@RequiresPermissions("monitor:logininfor:view")
	@GetMapping()
	public String logininfor() {
		return prefix + "/logininfor";
	}

	@RequiresPermissions("monitor:logininfor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysLogininfor logininfor) {
		startPage();
		List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
		return getDataTable(list);
	}

	@Log(title = "登陆日志", businessType = BusinessType.EXPORT)
	@RequiresPermissions("monitor:logininfor:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SysLogininfor logininfor) {
		List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
		ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
		return util.exportExcel(list, "登陆日志");
	}

	@RequiresPermissions("monitor:logininfor:remove")
	@Log(title = "登陆日志", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(logininforService.deleteLogininforByIds(ids));
	}

	@RequiresPermissions("monitor:logininfor:remove")
	@Log(title = "登陆日志", businessType = BusinessType.CLEAN)
	@PostMapping("/clean")
	@ResponseBody
	public AjaxResult clean() {
		logininforService.cleanLogininfor();
		return success();
	}

	@RequiresPermissions("monitor:logininfor:unlock")
	@Log(title = "账户解锁", businessType = BusinessType.OTHER)
	@PostMapping("/unlock")
	@ResponseBody
	public AjaxResult unlock(String loginName) {
		passwordService.unlock(loginName);
		return success();
	}
}
