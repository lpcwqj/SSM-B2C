package service.before;

import pojo.Goods;
import pojo.Orderbase;
import pojo.Orderdetail;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/17
 */
public interface OrderService {
    /**
     * 根据订单id查询订单详情
     * 商品的详情和购买数量
     * @param id
     */
    List<Goods> findOrderDetail(int id);

    /**
     * 接收订单金额 写入数据库
     */
    void insertOrder(Orderbase orderbase);

    /**
     * 接收支付成功的订单编号 更新订单的状态为已支付
     * @param id
     */
    void updateStatus(int id);

    /**
     * 获得刚插入的订单的id
     * @return
     */
    int selectLastId();

    /**
     * 订单成功支付后，删除该订单包含的购物车信息
     * @param id
     */
    void deleteCartById(int id);

    /**
     * 查询数据 用于添加订单详情
     * @param last_id
     * @return
     */
    List<Orderdetail> select(int last_id);

    /**
     * 添加订单详情
     * @param orderdetail
     */
    void insertOrderDetail(Orderdetail orderdetail);

    /**
     * 订单支付成功后，减少商品库存
     * @param id    订单id
     */
    void updateGoodsStore(int id);
}
