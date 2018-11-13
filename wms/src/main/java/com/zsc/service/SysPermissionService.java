package com.zsc.service;

import java.util.List;

import com.zsc.pojo.SysPermission;

/**
 * <p>Title: SysPermissionService</p>
 * <p>Description: 系统资源权限</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月24日
 */
public interface SysPermissionService {
	/**
	 * 
	 * <p>Title: getSysPermissions</p>
	 * <p>Description: 获取系统权限资源</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月29日
	 * @param sysPermission
	 * @return
	 */
	public List<SysPermission> query(SysPermission sysPermission);
	
	/**
	 * 
	 * <p>Title: save</p>
	 * <p>Description: 保存权限资源</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月29日
	 * @param sysPermission
	 * @return
	 */
	public SysPermission save(SysPermission sysPermission);
	
	/**
	 * 
	 * <p>Title: update</p>
	 * <p>Description: 更新</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月29日
	 * @param sysPermission
	 */
	public void update(SysPermission sysPermission);
	
	/**
	 * 
	 * <p>Title: delete</p>
	 * <p>Description: 禁用</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月30日
	 * @param sysPermission
	 */
	public void delete(SysPermission sysPermission);
}
