package com.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import com.delivery.common.annotation.Log;
import com.delivery.common.core.controller.BaseController;
import com.delivery.common.core.domain.AjaxResult;
import com.delivery.common.core.page.TableDataInfo;
import com.delivery.common.enums.BusinessType;
import com.delivery.common.utils.poi.ExcelUtil;
import com.delivery.common.utils.uuid.IdUtils;
import com.delivery.domain.DeliveryCard;
import com.delivery.dto.CardDto;
import com.delivery.service.IDeliveryCardService;
import com.delivery.system.domain.SysConfig;
import com.delivery.system.utils.DictUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 卡劵Controller
 *
 * @author jcohy
 * @date 2020-09-17
 */
@Controller
@RequestMapping("/system/card")
public class DeliveryCardController extends BaseController {
	private String prefix = "/system/card";

	@Autowired
	private IDeliveryCardService deliveryCardService;

	@RequiresPermissions("system:card:view")
	@GetMapping()
	public String delivery() {
		return prefix + "/delivery";
	}

	/**
	 * 查询卡劵列表
	 */
	@RequiresPermissions("system:card:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DeliveryCard deliveryCard) {
		startPage();
		List<DeliveryCard> list = deliveryCardService.selectDeliveryCardList(deliveryCard);
		return getDataTable(list);
	}

	/**
	 * 导出卡劵列表
	 */
	@RequiresPermissions("system:card:export")
	@Log(title = "卡劵", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(DeliveryCard deliveryCard) {
		List<DeliveryCard> list = deliveryCardService.selectDeliveryCardList(deliveryCard);
		ExcelUtil<DeliveryCard> util = new ExcelUtil<DeliveryCard>(DeliveryCard.class);
		return util.exportExcel(list, "delivery");
	}

	/**
	 * 新增卡劵
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存卡劵
	 */
	@RequiresPermissions("system:card:add")
	@Log(title = "卡劵", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@Valid CardDto cardDto) {

		Integer number = cardDto.getNumber();
		for (int i = 0; i < number; i++) {
			DeliveryCard deliveryCard = new DeliveryCard();
			String cardNo = IdUtils.generateNumber(12);
			String password = IdUtils.generateNumber(6);
			deliveryCard.setCardNo(cardNo);
			deliveryCard.setCardStatus(DictUtils.getDictValue("card_status","待处理"));
			deliveryCard.setCardPassword(password);
			deliveryCard.setCardShop(cardDto.getName());
			deliveryCardService.insertDeliveryCard(deliveryCard);
		}

		return toAjax(true);
	}

	/**
	 * 修改卡劵
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		DeliveryCard deliveryCard =
				deliveryCardService.selectDeliveryCardById(id);
		mmap.put("deliveryCard", deliveryCard);
		return prefix + "/edit";
	}

	/**
	 * 修改保存卡劵
	 */
	@RequiresPermissions("system:card:edit")
	@Log(title = "卡劵", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DeliveryCard deliveryCard) {
		return toAjax(deliveryCardService.updateDeliveryCard(deliveryCard));
	}

	/**
	 * 删除卡劵
	 */
	@RequiresPermissions("system:card:remove")
	@Log(title = "卡劵", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(deliveryCardService.deleteDeliveryCardByIds(ids));
	}

}
