package com.zsc.service;

import java.util.List;

import com.zsc.pojo.SysRole;
import com.zsc.pojo.SysRolePermission;

/**
 * 
 * <p>Title: SysRoleService</p>
 * <p>Description: 角色service</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月30日
 */
public interface SysRoleService {

	public List<SysRole> query(SysRole sysRole);

	public SysRole save(SysRole sysRole);
	
	public void update(SysRole sysRole);
	
	public void delete(SysRole sysRole);
	/**
	 * 
	 * <p>Title: getPermIdsByRoleId</p>
	 * <p>Description: 根据角色id查询角色资源表中的记录</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年11月1日
	 * @param roleId
	 * @return
	 */
	public List<SysRolePermission> getPermIdsByRoleId(String roleId);
	/**
	 * 
	 * <p>Title: delByRoleId</p>
	 * <p>Description: 根据角色id删除角色资源表中记录</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年11月1日
	 * @param roleId
	 */
	public void delByRoleId(String roleId);
	/**
	 * 
	 * <p>Title: save</p>
	 * <p>Description: 插入角色资源记录</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年11月1日
	 * @param sysRolePermission
	 * @return
	 */
	public SysRolePermission save(SysRolePermission sysRolePermission);
}
