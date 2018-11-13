package com.zsc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.zsc.dao.SysRoleMapper;
import com.zsc.dao.SysRolePermissionMapper;
import com.zsc.pojo.SysRole;
import com.zsc.pojo.SysRoleExample;
import com.zsc.pojo.SysRoleExample.Criteria;
import com.zsc.pojo.SysRolePermission;
import com.zsc.pojo.SysRolePermissionExample;
import com.zsc.service.SysRoleService;

/**
 * <p>Title: SysRoleServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月30日
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;
	@Override
	public List<SysRole> query(SysRole sysRole) {
		SysRoleExample example = new SysRoleExample();
		Criteria criteria = example.createCriteria();
		//过滤超级管理员角色
		criteria.andIdNotEqualTo("1");
		if(!StringUtils.isEmpty(sysRole.getId())) {
			criteria.andIdLike(sysRole.getId());
		}
		if(!StringUtils.isEmpty(sysRole.getName())) {
			criteria.andNameLike(sysRole.getName());
		}
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		return list;
	}

	@Override
	public SysRole save(SysRole sysRole) {
		sysRoleMapper.insert(sysRole);
		return sysRole;
	}

	@Override
	public void update(SysRole sysRole) {
		sysRoleMapper.updateByPrimaryKey(sysRole);
	}

	@Override
	public void delete(SysRole sysRole) {
		sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	}

	@Override
	public List<SysRolePermission> getPermIdsByRoleId(String roleId) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		com.zsc.pojo.SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(roleId);
		List<SysRolePermission> list = sysRolePermissionMapper.selectByExample(example);
		return list;
	}

	@Override
	public void delByRoleId(String roleId) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		com.zsc.pojo.SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(roleId);
		sysRolePermissionMapper.deleteByExample(example);
	}

	@Override
	public SysRolePermission save(SysRolePermission sysRolePermission) {
		sysRolePermissionMapper.insert(sysRolePermission);
		return sysRolePermission;
	}

}
