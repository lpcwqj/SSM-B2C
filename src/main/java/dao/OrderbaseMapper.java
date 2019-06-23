package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Orderbase;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface OrderbaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderbase record);

    int insertSelective(Orderbase record);

    Orderbase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderbase record);

    int updateByPrimaryKey(Orderbase record);

    /**
     * 查询订单列表
     */
    List<Orderbase> findOrderList();

    /**
     * 接收支付成功的订单编号 更新订单的状态为已支付
     * @param id
     */
    void updateStatus(@Param("id") int id);

    /**
     * 获得刚插入的订单的id
     * @return
     */
    int selectLastId();

    /**
     * 订单成功支付后，删除该订单包含的购物车信息
     * @param id
     */
    void deleteCartById(@Param("id") int id);
}