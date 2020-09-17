package com.delivery.utils;

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
		message.setText(deliveryCard.toString());
		//发送邮件
		mailSender.send(message);
	}
}
