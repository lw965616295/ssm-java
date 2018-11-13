package com.zsc.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsc.pojo.SysPermission;
import com.zsc.service.SysPermissionService;
import com.zsc.utils.Constants;

/**
 * <p>Title: SysPermissionController</p>
 * <p>Description: 系统权限资源controller</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月24日
 */
@Controller
@RequestMapping("perm")
public class PermissionController extends BaseController{
	/**权限service*/
	@Autowired
	private SysPermissionService sysPermissionService;
	
	/**
	 * 
	 * <p>Title: page</p>
	 * <p>Description: 跳转页面</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月24日
	 * @return
	 */
	@RequiresPermissions("perm:query")
	@RequestMapping("page")
	public String page() {
		return "permission";
	}
	
	/**
	 * 
	 * <p>Title: query</p>
	 * <p>Description: 查询权限资源</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月25日
	 * @param sysPermission
	 * @return
	 */
	@RequiresPermissions("perm:query")
	@RequestMapping("query")
	@ResponseBody
	public String query(SysPermission sysPermission) {
		startPagination();
		List<SysPermission> sysPermissions = sysPermissionService.query(sysPermission);
		for (SysPermission permission : sysPermissions) {
			logger.info("-------------->permission:"+permission);
		}
		return getResultJsonStr(Constants.RETURN_SUCCESS, "返回成功！", sysPermissions);
	}
	/**
	 * 
	 * <p>Title: save</p>
	 * <p>Description: 保存</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月29日
	 * @param sysPermission
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public String save(SysPermission sysPermission) {
		try {
			sysPermissionService.save(sysPermission);
			return getResultJsonStr(Constants.RETURN_SUCCESS, "保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return getResultJsonStr(Constants.RETRUN_FAILURE, e.getMessage());
		}
	}
	
	/**
	 * 
	 * <p>Title: update</p>
	 * <p>Description: 更新操作</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月30日
	 * @param sysPermission
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(SysPermission sysPermission) {
		try {
			sysPermissionService.update(sysPermission);
			return getResultJsonStr(Constants.RETURN_SUCCESS, "更新成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return getResultJsonStr(Constants.RETRUN_FAILURE, e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * <p>Title: delete</p>
	 * <p>Description: 作废</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月30日
	 * @param sysPermission
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(SysPermission sysPermission) {
		try {
			sysPermissionService.delete(sysPermission);
			return getResultJsonStr(Constants.RETURN_SUCCESS, "作废成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return getResultJsonStr(Constants.RETRUN_FAILURE, e.getMessage());
		}
	}
}
