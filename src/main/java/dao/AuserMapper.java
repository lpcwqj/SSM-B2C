package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Auser;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface AuserMapper {
    int deleteByPrimaryKey(String aname);

    int insert(Auser record);

    int insertSelective(Auser record);

    Auser selectByPrimaryKey(String aname);

    int updateByPrimaryKeySelective(Auser record);

    int updateByPrimaryKey(Auser record);

    /**
     * 根据输入的用户名检查数据库中是否存在该用户
     * @param username
     */
    Auser checkUserByUsername(@Param("username") String username);
}