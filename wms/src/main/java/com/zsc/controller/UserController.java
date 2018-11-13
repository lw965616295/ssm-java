package com.zsc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zsc.pojo.TMdUser;
import com.zsc.service.UserService;
import com.zsc.utils.Constants;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年9月20日
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * <p>Title: page</p>
	 * <p>Description: 跳转用户页面</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月20日
	 * @return
	 */
	@RequiresPermissions("user:query")
	@RequestMapping("page")
	public String page() {
		return "user";
	}

	@ResponseBody
	@RequestMapping(value = "query")
	public String query() {
		startPagination();
		List<TMdUser> all = userService.getAll();
		for (TMdUser user : all) {
			System.err.println(user);
		}
		String resultJsonStr = getResultJsonStr(Constants.RETURN_SUCCESS, "返回成功！", all);
		return resultJsonStr;
	} 

}
