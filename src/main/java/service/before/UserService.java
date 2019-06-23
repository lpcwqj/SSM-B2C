package service.before;

import pojo.*;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/17
 */
public interface UserService {
    /**
     * 用户登录时通过邮箱验证用户是否存在
     * @param email
     * @return
     */
    Buser checkUserByEmail(String email);

    /**
     * 实现注册用户
     * @param buser
     */
    void addUser(Buser buser);

    /**
     * 查询当前用户的订单
     * @param buserEmail 通过该用户的邮箱
     * @return
     */
    List<Orderbase> findAllOrder(String buserEmail);

    /**
     * 查询该用户关注的商品
     * @param buserEmail 通过该用户的邮箱
     * @return
     */
    List<Goods> findFocusGoods(String buserEmail);

    /**
     * 用户根据id查看商品详情
     */
    Goods findGoodsDetail(int id);

    /**
     * 查询销售排行
     * @return
     */
    List<Goods> selectOrderByShoppingNum();

    /**
     * 查询人气排行
     * @return
     */
    List<Goods> selectPeopleHot();

    /**
     * 查询最新商品
     * @return
     */
    List<Goods> selectAllGoods();
}
