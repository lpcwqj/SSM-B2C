package service.before;

import pojo.Cart;
import pojo.Goods;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/18
 */
public interface CartService {
    /**
     * 添加购物车
     */
    void insert(Cart cart);

    /**
     * 删除购物车中的指定商品
     * @param id    前台传来的id
     */
    void deleteById(int id);

    /**
     * 查询购物车中的全部信息
     * @return
     */
    List<Goods> selectCart();

    /**
     * 清空购物车
     */
    void deleteCart();

}
