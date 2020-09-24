package com.delivery.web.controller.front;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.delivery.common.core.domain.AjaxResult;
import com.delivery.common.utils.StringUtils;
import com.delivery.domain.DeliveryCard;
import com.delivery.dto.IndexDto;
import com.delivery.enums.CardStatus;
import com.delivery.service.IDeliveryCardService;
import com.delivery.system.utils.DictUtils;
import com.delivery.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jcohy
 */
@Controller
@RequestMapping("/front")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	private String prefix = "front";

	@Autowired
	private IDeliveryCardService deliveryCardService;

	@Autowired
	private MailUtils mailUtils;

	@GetMapping()
	public String index(@RequestParam @NotNull String t, ModelMap mmap) {
		logger.info("cardNo = {}", t);
		mmap.put("t", t);
		return prefix + "/index";
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/checkPassword")
	@ResponseBody
	public AjaxResult checkPassword(DeliveryCard deliveryCard, ModelMap mmap) {
		logger.info("checkPassword | deliveryCard = {}", deliveryCard.toString());
		DeliveryCard card = deliveryCardService.selectDeliveryCardByCardNo(deliveryCard.getCardNo());
		if (StringUtils.isNotNull(card)) {
			if (card.getCardStatus().equals(DictUtils.getDictValue(CardStatus.WRITE_OFF.getKey(), CardStatus.WRITE_OFF.getLabel()))) {
				return AjaxResult.error("此卡已被使用");
			}
			if (deliveryCard.getCardPassword().equals(card.getCardPassword())) {
				return AjaxResult.success(card);
			}
			return AjaxResult.error();
		}
		return AjaxResult.error();
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/saveUser")
	public String saveUser(@Valid IndexDto indexDto) {
		logger.info("saveUser | IndexDto = {}", indexDto.toString());
		DeliveryCard deliveryCard = deliveryCardService.selectDeliveryCardByCardNo(indexDto.getCardNo());
		// 卡劵已生成并且未被核销
		if(!deliveryCard.getCardStatus().equals(DictUtils.getDictValue(CardStatus.NOT_WRITE_OFF.getKey(), CardStatus.NOT_WRITE_OFF.getLabel()))){
			return "system/card/fail";
		}
		deliveryCard.setUserName(indexDto.getUserName());
		deliveryCard.setPhone(indexDto.getPhone());
		deliveryCard.setCardShop(indexDto.getCardShop());
		StringBuilder sb = new StringBuilder();
		sb.append(indexDto.getProvince())
				.append(indexDto.getCity())
				.append(indexDto.getArea())
				.append(indexDto.getAddress());
		deliveryCard.setAddress(sb.toString());
		deliveryCard.setRemark(indexDto.getRemark());
		deliveryCard.setCardStatus(DictUtils.getDictValue(CardStatus.WRITE_OFF.getKey(), CardStatus.WRITE_OFF.getLabel()));
		deliveryCardService.updateDeliveryCard(deliveryCard);
		mailUtils.simpleMailSend(deliveryCard);
		return "system/card/success";
	}

//	@GetMapping("/send")
//	@ResponseBody
//	public String send() {
//		DeliveryCard deliveryCard = deliveryCardService.selectDeliveryCardById(1L);
//		mailUtils.simpleMailSend(deliveryCard);
//		return "success";
//	}
}
