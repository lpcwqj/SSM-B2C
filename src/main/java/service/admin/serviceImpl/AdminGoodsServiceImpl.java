package service.admin.serviceImpl;

import dao.GoodsMapper;
import dao.GoodstypeMapper;
import dao.OrderdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Goods;
import pojo.Goodstype;
import pojo.Orderdetail;
import service.admin.AdminGoodsService;
import utils.PageUtils;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/14
 */
@Service
@Transactional
public class AdminGoodsServiceImpl implements AdminGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodstypeMapper goodstypeMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public PageUtils<Goods> selectGoods(int currentPage) {
        PageUtils<Goods> goods = new PageUtils<>();
        //定义每页显示的记录数
        int pageSize = 15;
        //查询总记录数
        int totalCount = goodsMapper.findCount();
        double tc =totalCount;
        //查询总页数
        int totalPage = (int)Math.ceil(tc/pageSize);
        //查询每页显示的结果集
        int start = (currentPage-1) * pageSize;
        List<Goods> lists = goodsMapper.findLists(start,pageSize);

        //开始封装
        goods.setCurrentPage(currentPage);
        goods.setPageSize(pageSize);
        goods.setTotalCount(totalCount);
        goods.setTotalPage(totalPage);
        goods.setList(lists);
        return goods;
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    @Override
    public List<Goodstype> findGoodsTypeName() {
        return goodstypeMapper.findGoodsTypeName();
    }

    @Override
    public Goods findGoodsById(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public String findGoodsTypeNameById(int id) {
        return goodsMapper.findtypenameById(id);
    }

    @Override
    public void deleteAGoods(int id) {
        goodsMapper.deleteAGoods(id);
    }

    @Override
    public void deleteGoods(Integer[] ids) {
        goodsMapper.deleteGoods(ids);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public Orderdetail findIfHaveGoods(int id) {
        return orderdetailMapper.findIfHaveGoods(id);
    }

    @Override
    public List<Orderdetail> findIfHaveGoodsByIds(Integer[] ids) {
        return orderdetailMapper.findIfHaveGoodsByIds(ids);
    }
}
