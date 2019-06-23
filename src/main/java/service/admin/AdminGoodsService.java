package service.admin;


import pojo.Goods;
import pojo.Goodstype;
import utils.PageUtils;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/14
 *
 * 业务逻辑层 管理员管理商品
 */
public interface AdminGoodsService {

    /**
     * 分页
     * @param currentPage 前台传来参数currentPage:当前页数
     * @return
     */
    PageUtils<Goods> selectGoods(int currentPage);

    /**
     * 添加商品
     * @param goods 后台接收前台发来的表单数据
     */
    void addGoods(Goods goods);

    /**
     * 查询商品类型
     */
    List<Goodstype> findGoodsTypeName();

    /**
     * 根据ID查询商品信息 用于回显数据
     * @param id 前台传来的参数ID
     */
    Goods findGoodsById(int id);

    /**
     * 根据商品ID查询商品类型名称
     * @param id
     * @return
     */
    String findGoodsTypeNameById(int id);

    /**
     * 删除一个商品
     * @param id 前台传来的参数ID
     */
    void deleteAGoods(int id);

    /**
     * 批量删除
     * @param ids 前台传来的参数 数组ID
     */
    void deleteGoods(Integer[] ids);

    /**
     * 更新商品
     * @param goods 前台传来的表单数据 封装为goods对象
     */
    void updateGoods(Goods goods);
}
