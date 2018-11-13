package com.zsc.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.zsc.pojo.SysPermission;
import com.zsc.pojo.SysRole;
import com.zsc.pojo.SysRolePermission;
import com.zsc.service.SysPermissionService;
import com.zsc.service.SysRoleService;
import com.zsc.utils.Constants;

/**
 * 
 * <p>Title: RoleController</p>
 * <p>Description: 角色controller</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月30日
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController{
	/**角色service*/
	@Autowired
	private SysRoleService sysRoleService;
	/**权限资源service*/
	@Autowired
	private SysPermissionService sysPermissionService;
	
	/**
	 * 
	 * <p>Title: page</p>
	 * <p>Description: 跳转页面</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月30日
	 * @return
	 */
	@RequiresPermissions("role:query")
	@RequestMapping("page")
	public String page() {
		return "role";
	}
	
	/**
	 * 
	 * <p>Title: query</p>
	 * <p>Description: </p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月30日
	 * @param sysRole
	 * @return
	 */
	@RequiresPermissions("role:query")
	@RequestMapping("query")
	@ResponseBody
	public String query(SysRole sysRole) {
		startPagination();
		List<SysRole> roles = sysRoleService.query(sysRole);
		for (SysRole role : roles) {
			logger.info("-------------->role:"+role);
		}
		return getResultJsonStr(Constants.RETURN_SUCCESS, "返回成功！", roles);
	}
	/**
	 * 
	 * <p>Title: save</p>
	 * <p>Description: 保存</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年10月30日
	 * @param sysRole
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public String save(SysRole sysRole) {
		try {
			sysRole.setId(getUuid());
			sysRoleService.save(sysRole);
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
	 * @param sysRole
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(SysRole sysRole) {
		try {
			sysRoleService.update(sysRole);
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
	 * @param sysRole
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(SysRole sysRole) {
		try {
			sysRoleService.delete(sysRole);
			return getResultJsonStr(Constants.RETURN_SUCCESS, "作废成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return getResultJsonStr(Constants.RETRUN_FAILURE, e.getMessage());
		}
	}
	
	/**
	 * 
	 * <p>Title: getAllPerms</p>
	 * <p>Description: 获取所有权限资源</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年11月1日
	 * @param sysPermission
	 * @return
	 */
	@RequestMapping("getAllPerms")
	@ResponseBody
	public String getAllPerms(SysPermission sysPermission) {
		List<SysPermission> sysPermissions = sysPermissionService.query(sysPermission);
		for (SysPermission permission : sysPermissions) {
			logger.info("-------------->permission:"+permission);
		}
		return getResultJsonStr(Constants.RETURN_SUCCESS, "返回成功！", sysPermissions);
	}
	
	/**
	 * 
	 * <p>Title: getPermIdsByRoleId</p>
	 * <p>Description: 通过角色id获取该角色对应的资源</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年11月1日
	 * @param roleId
	 * @return
	 */
	@RequestMapping("getPermIdsByRoleId")
	@ResponseBody
	public String getPermIdsByRoleId(String roleId) {
		List<SysRolePermission> list = sysRoleService.getPermIdsByRoleId(roleId);
		for (SysRolePermission sysRolePermission : list) {
			logger.info("-------------->sysRolePermission:"+sysRolePermission);
		}
		return getResultJsonStr(Constants.RETURN_SUCCESS, "返回成功！", list);
	}
	
	/**
	 * 
	 * <p>Title: author</p>
	 * <p>Description: 授权</p>
	 * <p>Company: </p>
	 * @author weil
	 * @date 2018年11月1日
	 * @param roleId
	 * @param ids
	 * @return
	 */
	@RequestMapping("author")
	@ResponseBody
	public String author(String roleId, String ids) {
		String[] split = ids.split(",");
		logger.info("split.length---------->"+split.length);
		try {
			//删除该角色在角色资源表中的记录
			sysRoleService.delByRoleId(roleId);
			//重新再插入记录
			if(split.length > 0 && !StringUtils.isEmpty(split[0])) {
				
				for (String id : split) {
					SysRolePermission sysRolePermission = new SysRolePermission();
					sysRolePermission.setId(getUuid());
					sysRolePermission.setSysPermissionId(id);
					sysRolePermission.setSysRoleId(roleId);
					//保存
					sysRoleService.save(sysRolePermission);
				}
			}
		} catch (Exception e) {
			return getResultJsonStr(Constants.RETRUN_FAILURE, "授权失败！"+e.getMessage());
		}
		return getResultJsonStr(Constants.RETURN_SUCCESS, "授权成功！");
	}
}
