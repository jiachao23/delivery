package com.delivery.system.mapper;

import java.util.List;

import com.delivery.system.domain.SysNotice;

/**
 * 公告 数据层
 * @author jiac
 */
public interface SysNoticeMapper {
	/**
	 * 查询公告信息
	 *
	 * @param noticeId 公告ID
	 * @return 公告信息
	 */
	public SysNotice selectNoticeById(Long noticeId);

	/**
	 * 查询公告列表
	 *
	 * @param notice 公告信息
	 * @return 公告集合
	 */
	List<SysNotice> selectNoticeList(SysNotice notice);

	/**
	 * 新增公告
	 *
	 * @param notice 公告信息
	 * @return 结果
	 */
	int insertNotice(SysNotice notice);

	/**
	 * 修改公告
	 *
	 * @param notice 公告信息
	 * @return 结果
	 */
	int updateNotice(SysNotice notice);

	/**
	 * 批量删除公告
	 *
	 * @param noticeIds 需要删除的数据ID
	 * @return 结果
	 */
	int deleteNoticeByIds(String[] noticeIds);
}