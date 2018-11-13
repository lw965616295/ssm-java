package com.zsc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsc.dao.TMdUserMapper;
import com.zsc.pojo.TMdUser;
import com.zsc.pojo.TMdUserExample;
import com.zsc.service.UserService;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author weil
 * @date 2018年9月20日
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private TMdUserMapper userDao; 


	@Override
	public void addUser(TMdUser user) {
//		userDao.addUser(user);
//		int a = 1/0;
	}

	@Override
	public List<TMdUser> getAll() {
		TMdUserExample example = new TMdUserExample();
		
		List<TMdUser> all = userDao.selectByExample(example);
		return all;
	}

}
