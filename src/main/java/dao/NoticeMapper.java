package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Notice;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    /**
     * 查询所有公告
     * @return
     */
    List<Notice> findAllNotice();

}