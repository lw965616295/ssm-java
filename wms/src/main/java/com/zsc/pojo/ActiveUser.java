package com.zsc.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ActiveUser</p>
 * <p>Description: 存放于session中的用户信息</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月8日
 */
public class ActiveUser implements Serializable{

	private static final long serialVersionUID = 1L;
	/**用户id（主键）*/
	private String userid;
	/**用户名称*/
	private String username;
	/**菜单List<SysPermission>json字符串*/
	private String menus;
	/**权限List<SysPermission>json字符串*/
	private String permissions;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMenus() {
		return menus;
	}
	public void setMenus(String menus) {
		this.menus = menus;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "ActiveUser [userid=" + userid + ", username=" + username + ", menus=" + menus + ", permissions="
				+ permissions + "]";
	}
	
	
}
