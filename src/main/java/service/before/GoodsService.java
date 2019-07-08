package service.before;

import pojo.Goods;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/19
 */
public interface GoodsService {
    /**
     * 根据用户输入的商品类型名 模糊查询
     */
    List<Goods> Search(String goodsTypeName);

    /**
     * 根据商品类型id查询该类型所有商品
     * @param id
     * @return
     */
    List<Goods> findGoodsList(int id);
}
