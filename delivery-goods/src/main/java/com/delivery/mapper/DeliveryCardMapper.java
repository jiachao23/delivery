package com.delivery.mapper;

import java.util.List;

import com.delivery.domain.DeliveryCard;

/**
 * 卡劵Mapper接口
 *
 * @author jcohy
 * @date 2020-09-17
 */
public interface DeliveryCardMapper {
	/**
	 * 查询卡劵
	 *
	 * @param id 卡劵ID
	 * @return 卡劵
	 */
	public DeliveryCard selectDeliveryCardById(Long id);

	/**
	 * 查询卡劵列表
	 *
	 * @param deliveryCard 卡劵
	 * @return 卡劵集合
	 */
	public List<DeliveryCard> selectDeliveryCardList(DeliveryCard deliveryCard);

	/**
	 * 新增卡劵
	 *
	 * @param deliveryCard 卡劵
	 * @return 结果
	 */
	public int insertDeliveryCard(DeliveryCard deliveryCard);

	/**
	 * 修改卡劵
	 *
	 * @param deliveryCard 卡劵
	 * @return 结果
	 */
	public int updateDeliveryCard(DeliveryCard deliveryCard);

	/**
	 * 删除卡劵
	 *
	 * @param id 卡劵ID
	 * @return 结果
	 */
	public int deleteDeliveryCardById(Long id);

	/**
	 * 批量删除卡劵
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteDeliveryCardByIds(String[] ids);
}
