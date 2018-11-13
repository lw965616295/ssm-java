package com.zsc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zsc.pojo.ActiveUser;
import com.zsc.utils.CustomException;

/**
 * <p>Title: MainController</p>
 * <p>Description: 主controller</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月9日
 */
@Controller
public class MainController extends BaseController{
	/**
	 * 
	 * <p>Title: login</p>
	 * <p>Description: 未认证进行认证</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月10日
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		//防止已认证后，再次调用登录页面进行登录
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			return "forward:home";
		}
		//获取shiro认证失败异常信息
		String exceptionStr = (String) getRequest().getAttribute("shiroLoginFailure");
		if(exceptionStr != null) {
			if(UnknownAccountException.class.getName().equals(exceptionStr)) {
				throw new CustomException("账号不存在！");
			}else if(IncorrectCredentialsException.class.getName().equals(exceptionStr)) {
				throw new CustomException("用户名或密码错误！");
			}else {
				throw new CustomException("认证失败！");
			}
		}
		//没有认证跳转认证界面
		return "login";
	}
	
	/**
	 * 
	 * <p>Title: home</p>
	 * <p>Description: 登录成功主页面</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月10日
	 * @param model
	 * @return
	 */
	@RequestMapping("home")
	public String home(Model model) {
		ActiveUser activeUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
		//如果主体不存在，跳转登录界面重新登录
		if(activeUser == null) {
			return "login";
		}
		model.addAttribute("activeUser",activeUser);
		return "home";
	}
}
