package com.zsc.dao;

import com.zsc.pojo.TSclAccount;
import com.zsc.pojo.TSclAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSclAccountMapper {
    int countByExample(TSclAccountExample example);

    int deleteByExample(TSclAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSclAccount record);

    int insertSelective(TSclAccount record);

    List<TSclAccount> selectByExample(TSclAccountExample example);

    TSclAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSclAccount record, @Param("example") TSclAccountExample example);

    int updateByExample(@Param("record") TSclAccount record, @Param("example") TSclAccountExample example);

    int updateByPrimaryKeySelective(TSclAccount record);

    int updateByPrimaryKey(TSclAccount record);
}