package service.before.serviceImpl;

import dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Goods;
import service.before.GoodsService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/19
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> Search(String goodsTypeName) {


        return goodsMapper.Search(goodsTypeName);



    }

    @Override
    public List<Goods> findGoodsList(int id) {
        return goodsMapper.findGoodsList(id);
    }
}
