package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Cart;
import pojo.Goods;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /**
     * 删除该用户的购物车中的指定商品
     * @param id    前台传来的id
     * @param user_id 用户id
     */
    void deleteById(@Param("id") int id,
                    @Param("user_id") int user_id);

    /**
     * 查询该用户的购物车的信息
     * @return
     */
    List<Goods> selectCart(@Param("id") int id);

    /**
     * 清空该用户的购物车
     */
    void deleteCart(@Param("id") int id);
}