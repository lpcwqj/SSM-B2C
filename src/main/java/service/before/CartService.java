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
     * @param user_id 用户id
     */
    void deleteById(int id,int user_id);

    /**
     * 查询该用户的购物车中的全部信息
     * @return
     */
    List<Goods> selectCart(int id);

    /**
     * 清空该用户的购物车
     */
    void deleteCart(int id);

}
