package service.admin;

import pojo.Orderbase;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 *
 * 业务逻辑层 管理员管理用户下的订单
 */
public interface AdminOrderService {
    /**
     * 查询订单列表
     */
    List<Orderbase> findOrderList();

    /**
     * 删除订单
     * @param id 前台传来的参数ID
     */
    void deleteOrderById(int id);
}
