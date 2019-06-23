package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Buser;
import pojo.Focus;
import pojo.Orderbase;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface BuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Buser record);

    int insertSelective(Buser record);

    Buser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buser record);

    int updateByPrimaryKey(Buser record);

    /**
     * 查询用户列表
     */
    List<Buser> findUserList();

    /**
     * 通过邮箱验证用户是否存在
     */
    Buser checkUserByEmail(@Param("email") String email);

    /**
     * 查询当前用户的全部订单
     * @return
     */
    List<Orderbase> findAllOrder(@Param("buserEmail") String buserEmail);

    /**
     * 根据用户邮箱查询用户id
     */
    int selectId(@Param("email") String email);
}