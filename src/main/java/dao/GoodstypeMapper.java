package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Goodstype;

import java.util.List;

/**
 * @author Lin
 * @Date  2019/6/14
 */

@Mapper
public interface GoodstypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    Goodstype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);

    /**
     *  查询商品类型
     */
    List<Goodstype> findGoodsTypeName();

    /**
     * 查询有几个类型
     */
    int findCount();

    /**
     * 查询用于分页显示类型集合
     */
    List<Goodstype> findLists(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 查询商品类型列表
     */
    List<Goodstype> selectGoodsType();
}