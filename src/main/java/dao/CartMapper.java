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
     * 删除购物车中的指定商品
     * @param id    前台传来的id
     */
    void deleteById(@Param("id") int id);

    /**
     * 查询购物车的信息
     * @return
     */
    List<Goods> selectCart();

    /**
     * 清空购物车
     */
    void deleteCart();
}