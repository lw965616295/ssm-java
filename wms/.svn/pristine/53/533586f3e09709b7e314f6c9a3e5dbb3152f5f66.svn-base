package com.zsc.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.zsc.pojo.ActiveUser;
import com.zsc.pojo.SysPermission;
import com.zsc.pojo.TMdUser;
import com.zsc.service.SysService;

/**
 * <p>Title: CustomRealm</p>
 * <p>Description: 自定义shiro域</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月9日
 */
public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private SysService sysService;
	Logger logger = Logger.getLogger(this.getClass());
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		//通过用户提交的用户名查询数据库
		TMdUser user = null;
		try {
			user = sysService.findUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//用户名不存在
		if(user == null) {
			throw new UnknownAccountException();
		}
		
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUsername(user.getUserName());
		activeUser.setUserid(user.getUserId()+"");
		//根据用户id获取对应菜单
		List<SysPermission> menus = null;
		try {
			menus = sysService.findMenusById(activeUser.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(menus != null) {
			String menuStr = JSON.toJSONString(menus);
			activeUser.setMenus(menuStr);
		}
		logger.info("----------------->activeUser:"+activeUser);
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser,user.getPassWord(),this.getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiveUser activeUser= (ActiveUser)principals.getPrimaryPrincipal();
		List<String> pStrings = new ArrayList<>();
		try {
			List<SysPermission> permissions = sysService.findPermissionsById(activeUser.getUserid());
			
			for (SysPermission sysPermission : permissions) {
				pStrings.add(sysPermission.getPercode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("---------------->pStrings:"+pStrings.toString());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(pStrings);
		return authorizationInfo;
	}
	/**
	 * 
	 * <p>Title: clearCache</p>
	 * <p>Description: 清除缓存</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月22日
	 */
	public void clearCache() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

	
}
