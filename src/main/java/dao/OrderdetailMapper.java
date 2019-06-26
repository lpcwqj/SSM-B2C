package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Orderdetail;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);

    /**
     * 查询数据 用于添加商品详情
     * @param last_id
     * @return
     */
    List<Orderdetail> select(@Param("last_id") int last_id);

    /**
     * 查询订单中是否有要删除的商品
     * @param id
     * @return
     */
    Orderdetail findIfHaveGoods(@Param("id") int id);

    /**
     * 批量删除时 查询订单中是否有要删除的商品
     * @param ids
     * @return
     */
    List<Orderdetail> findIfHaveGoodsByIds(Integer[] ids);
}