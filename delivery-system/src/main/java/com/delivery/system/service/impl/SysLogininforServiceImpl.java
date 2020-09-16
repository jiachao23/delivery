package com.delivery.system.service.impl;

import java.util.List;

import com.delivery.common.core.text.Convert;
import com.delivery.system.domain.SysLogininfor;
import com.delivery.system.mapper.SysLogininforMapper;
import com.delivery.system.service.ISysLogininforService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统访问日志情况信息 服务层处理
 * @author jiac
 */
@Service
public class SysLogininforServiceImpl implements ISysLogininforService {

	@Autowired
	private SysLogininforMapper logininforMapper;

	/**
	 * 新增系统登录日志
	 *
	 * @param logininfor 访问日志对象
	 */
	@Override
	public void insertLogininfor(SysLogininfor logininfor) {
		logininforMapper.insertLogininfor(logininfor);
	}

	/**
	 * 查询系统登录日志集合
	 *
	 * @param logininfor 访问日志对象
	 * @return 登录记录集合
	 */
	@Override
	public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor) {
		return logininforMapper.selectLogininforList(logininfor);
	}

	/**
	 * 批量删除系统登录日志
	 *
	 * @param ids 需要删除的数据
	 * @return
	 */
	@Override
	public int deleteLogininforByIds(String ids) {
		return logininforMapper.deleteLogininforByIds(Convert.toStrArray(ids));
	}

	/**
	 * 清空系统登录日志
	 */
	@Override
	public void cleanLogininfor() {
		logininforMapper.cleanLogininfor();
	}
}
