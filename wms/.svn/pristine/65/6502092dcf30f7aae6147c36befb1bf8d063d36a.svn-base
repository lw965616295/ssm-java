package com.zsc.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zsc.pojo.TMdUser;
import com.zsc.pojo.TMdUserExample;

public interface TMdUserMapper {
    int countByExample(TMdUserExample example);

    int deleteByExample(TMdUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TMdUser record);

    int insertSelective(TMdUser record);

    List<TMdUser> selectByExampleWithBLOBs(TMdUserExample example);

    List<TMdUser> selectByExample(TMdUserExample example);

    TMdUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TMdUser record, @Param("example") TMdUserExample example);

    int updateByExampleWithBLOBs(@Param("record") TMdUser record, @Param("example") TMdUserExample example);

    int updateByExample(@Param("record") TMdUser record, @Param("example") TMdUserExample example);

    int updateByPrimaryKeySelective(TMdUser record);

    int updateByPrimaryKeyWithBLOBs(TMdUser record);

    int updateByPrimaryKey(TMdUser record);
}