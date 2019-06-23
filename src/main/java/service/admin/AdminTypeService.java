package service.admin;

import pojo.Goodstype;
import utils.PageUtils;

/**
 * @author Lin
 * @Date 2019/6/16
 *
 * 业务逻辑层 管理员管理商品类型
 */
public interface AdminTypeService {

    /**
     * 商品类型分页
     */
    PageUtils<Goodstype> selectGoodsType(int currentPage);

    /**
     * 添加商品类型
     */
    void addType(Goodstype goodstype);

    /**
     * 删除商品类型
     * @param id 前台传来参数 id
     */
    void deleteTypeById(int id);
}
