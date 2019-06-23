package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Focus;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface FocusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Focus record);

    int insertSelective(Focus record);

    Focus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}