package com.zsc.service;

import java.util.List;

import com.zsc.pojo.SysPermission;
import com.zsc.pojo.TMdUser;

/**
 * <p>Title: SysService</p>
 * <p>Description: 系统service</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月9日
 */
public interface SysService {
	
	/**
	 * 
	 * <p>Title: findUserByUsername</p>
	 * <p>Description: 通过用户名查找用户信息</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月9日
	 * @param username 用户名
	 * @return
	 * @throws Exception
	 */
	public TMdUser findUserByUsername(String username) throws Exception;
	
	/**
	 * 
	 * <p>Title: findMenusById</p>
	 * <p>Description: 通过用户id查找授权的菜单</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月9日
	 * @param id 用户id
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findMenusById(String id) throws Exception;
	
	/**
	 * 
	 * <p>Title: findPermissionsById</p>
	 * <p>Description: 通过用户id查找授权权限</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月9日
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findPermissionsById(String id) throws Exception;
	
}
