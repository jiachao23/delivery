package com.delivery.service.impl;

import java.util.List;

import com.delivery.common.core.text.Convert;
import com.delivery.common.utils.DateUtils;
import com.delivery.domain.DeliveryCard;
import com.delivery.mapper.DeliveryCardMapper;
import com.delivery.service.IDeliveryCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卡劵Service业务层处理
 *
 * @author jcohy
 * @date 2020-09-17
 */
@Service
public class DeliveryCardServiceImpl implements IDeliveryCardService {
	@Autowired
	private DeliveryCardMapper deliveryCardMapper;

	/**
	 * 查询卡劵
	 *
	 * @param id 卡劵ID
	 * @return 卡劵
	 */
	@Override
	public DeliveryCard selectDeliveryCardById(Long id) {
		return deliveryCardMapper.selectDeliveryCardById(id);
	}

	@Override
	public DeliveryCard selectDeliveryCardByCardNo(String cardNo) {
		return deliveryCardMapper.selectDeliveryCardByCardNo(cardNo);
	}

	/**
	 * 查询卡劵列表
	 *
	 * @param deliveryCard 卡劵
	 * @return 卡劵
	 */
	@Override
	public List<DeliveryCard> selectDeliveryCardList(DeliveryCard deliveryCard) {
		return deliveryCardMapper.selectDeliveryCardList(deliveryCard);
	}

	/**
	 * 新增卡劵
	 *
	 * @param deliveryCard 卡劵
	 * @return 结果
	 */
	@Override
	public int insertDeliveryCard(DeliveryCard deliveryCard) {
		deliveryCard.setCreateTime(DateUtils.getNowDate());
		return deliveryCardMapper.insertDeliveryCard(deliveryCard);
	}

	/**
	 * 修改卡劵
	 *
	 * @param deliveryCard 卡劵
	 * @return 结果
	 */
	@Override
	public int updateDeliveryCard(DeliveryCard deliveryCard) {
		deliveryCard.setUpdateTime(DateUtils.getNowDate());
		return deliveryCardMapper.updateDeliveryCard(deliveryCard);
	}

	/**
	 * 删除卡劵对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteDeliveryCardByIds(String ids) {
		return deliveryCardMapper.deleteDeliveryCardByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除卡劵信息
	 *
	 * @param id 卡劵ID
	 * @return 结果
	 */
	@Override
	public int deleteDeliveryCardById(Long id) {
		return deliveryCardMapper.deleteDeliveryCardById(id);
	}
}
