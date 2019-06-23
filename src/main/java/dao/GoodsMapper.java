package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Focus;
import pojo.Goods;
import pojo.Goodstype;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查询总记录数
     */
    int findCount();

    /**
     * 封装查询每页的结果集合
     */
    List<Goods> findLists(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 根据商品ID查询商品类型名称
     */
    String findtypenameById(@Param("id") int id);


    /**
     * 根据商品ID删除商品
     */
    void deleteAGoods(@Param("id") int id);

    /**
     * 根据ID 批量删除
     * @param ids
     */
    void deleteGoods(Integer[] ids);

    /**
     * 查询该用户所关注的商品
     */
    List<Goods> findFocusGoods(@Param("buserEmail") String buserEmail);

    /**
     * 根据订单id查询订单详情
     * 商品的详情和购买数量
     * @param id
     */
    List<Goods> findOrderDetail(@Param("id") int id);

    /**
     * 用户根据id查询商品详情
     * @param id
     */
    Goods findGoodsDetail(@Param("id") int id);

    /**
     * 根据id查询商品
     */
    Goods selectById(@Param("goodsId") int goodsId);

    /**
     * 根据用户输入的商品类型名 模糊查询
     * @param goodsTypeName
     * @return
     */
    List<Goods> Search(@Param("goodsTypeName") String goodsTypeName);

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
     * 根据商品类型查询该类型所有的商品
     * @param id
     * @return
     */
    List<Goods> findGoodsList(@Param("id") int id);

    /**
     * 查询最新商品
     * @return
     */
    List<Goods> findAllGoods();

    /**
     * 订单支付成功后 减少商品库存
     * @param id    订单id
     */
    void updateGoodsStore(@Param("id") int id);
}