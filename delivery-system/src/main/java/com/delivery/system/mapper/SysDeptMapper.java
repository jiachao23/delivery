package com.delivery.system.mapper;

import java.util.List;

import com.delivery.system.domain.SysDept;
import org.apache.ibatis.annotations.Param;

/**
 * 部门管理 数据层
 * @author jiac
 */
public interface SysDeptMapper {
	/**
	 * 查询部门人数
	 *
	 * @param dept 部门信息
	 * @return 结果
	 */
	int selectDeptCount(SysDept dept);

	/**
	 * 查询部门是否存在用户
	 *
	 * @param deptId 部门ID
	 * @return 结果
	 */
	int checkDeptExistUser(Long deptId);

	/**
	 * 查询部门管理数据
	 *
	 * @param dept 部门信息
	 * @return 部门信息集合
	 */
	List<SysDept> selectDeptList(SysDept dept);

	/**
	 * 删除部门管理信息
	 *
	 * @param deptId 部门ID
	 * @return 结果
	 */
	int deleteDeptById(Long deptId);

	/**
	 * 新增部门信息
	 *
	 * @param dept 部门信息
	 * @return 结果
	 */
	int insertDept(SysDept dept);

	/**
	 * 修改部门信息
	 *
	 * @param dept 部门信息
	 * @return 结果
	 */
	int updateDept(SysDept dept);

	/**
	 * 修改子元素关系
	 *
	 * @param depts 子元素
	 * @return 结果
	 */
	int updateDeptChildren(@Param("depts") List<SysDept> depts);

	/**
	 * 根据部门名查询信息
	 *
	 * @param deptName 部门ID
	 * @return 部门信息
	 */
	SysDept selectDeptByDeptName(String deptName);

	/**
	 * 根据部门编码查询信息
	 *
	 * @param deptCode 部门ID
	 * @return 部门信息
	 */
	SysDept selectDeptByDeptCode(String deptCode);

	/**
	 * 根据部门ID查询信息
	 *
	 * @param deptId 部门ID
	 * @return 部门信息
	 */
	SysDept selectDeptById(Long deptId);

	/**
	 * 校验部门名称是否唯一
	 *
	 * @param deptName 部门名称
	 * @param parentId 父部门ID
	 * @return 结果
	 */
	SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

	/**
	 * 校验部门代码是否唯一
	 *
	 * @param deptCode 部门代码
	 * @param parentId 父部门ID
	 * @return 结果
	 */
	SysDept checkDeptCodeUnique(@Param("deptCode") String deptCode, @Param("parentId") Long parentId);

	/**
	 * 根据角色ID查询部门
	 *
	 * @param roleId 角色ID
	 * @return 部门列表
	 */
	List<String> selectRoleDeptTree(Long roleId);

	/**
	 * 修改所在部门的父级部门状态
	 *
	 * @param dept 部门
	 */
	void updateDeptStatus(SysDept dept);

	/**
	 * 根据ID查询所有子部门
	 *
	 * @param deptId 部门ID
	 * @return 部门列表
	 */
	List<SysDept> selectChildrenDeptById(Long deptId);

	/**
	 * 根据ID查询所有子部门（正常状态）
	 *
	 * @param deptId 部门ID
	 * @return 子部门数
	 */
	int selectNormalChildrenDeptById(Long deptId);
}
