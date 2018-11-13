package com.zsc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.zsc.dao.SysPermissionMapper;
import com.zsc.pojo.SysPermission;
import com.zsc.pojo.SysPermissionExample;
import com.zsc.pojo.SysPermissionExample.Criteria;
import com.zsc.service.SysPermissionService;

/**
 * <p>Title: SysPermissionServiceImpl</p>
 * <p>Description: 系统资源权限service</p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年10月24日
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Override
	public List<SysPermission> query(SysPermission sysPermission) {
		SysPermissionExample example = new SysPermissionExample();
		Criteria criteria = example.createCriteria();
		//过滤第一个系统权限
		criteria.andIdNotEqualTo(1);
		if(!StringUtils.isEmpty(sysPermission.getName())) {
			//根据名称查
			criteria.andNameLike(sysPermission.getName());
		}
		if(!StringUtils.isEmpty(sysPermission.getType())) {
			//根据类型查
			criteria.andTypeLike(sysPermission.getType());
		}
		example.setOrderByClause("id");
		List<SysPermission> sysPermissions = sysPermissionMapper.selectByExample(example);
		return sysPermissions;
	}
	
	@Override
	public SysPermission save(SysPermission sysPermission) {
		sysPermissionMapper.insert(sysPermission);
		return sysPermission;
	}

	@Override
	public void update(SysPermission sysPermission) {
		sysPermissionMapper.updateByPrimaryKey(sysPermission);
	}

	@Override
	public void delete(SysPermission sysPermission) {
		sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
	}

}
