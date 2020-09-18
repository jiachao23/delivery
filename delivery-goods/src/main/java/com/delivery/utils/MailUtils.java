package com.delivery.utils;

import java.util.Objects;

import com.delivery.domain.DeliveryCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2020 <a href="http://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description:
 *
 * @author jiac
 * @version 1.0.0 2020/8/14:15:32
 * @since 1.0.0
 */
@Component
public class MailUtils {

	@Autowired
	private MailProperties mailProperties;

	@Autowired
	private JavaMailSender mailSender;

	public void simpleMailSend(DeliveryCard deliveryCard) {
		//创建邮件内容
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailProperties.getUsername());
		message.setTo(mailProperties.getUsername());
		message.setSubject("您有新的订单了，请及时处理");
		message.setText(Objects.requireNonNull(createText(deliveryCard)));
		//发送邮件
		mailSender.send(message);
	}

	private String createText(DeliveryCard deliveryCard) {
		StringBuilder sb = new StringBuilder();
		sb.append("商品编号：").append(deliveryCard.getCardNo()).append(System.getProperty("line.separator"))
				.append("商品名：").append(deliveryCard.getCardShop()).append(System.getProperty("line.separator"))
				.append("用户名：").append(deliveryCard.getUserName()).append(System.getProperty("line.separator"))
				.append("用户电话：").append(deliveryCard.getPhone()).append(System.getProperty("line.separator"))
				.append("用户地址：").append(deliveryCard.getAddress()).append(System.getProperty("line.separator"))
				.append("备注：").append(deliveryCard.getRemark());
		return sb.toString();
	}
}
