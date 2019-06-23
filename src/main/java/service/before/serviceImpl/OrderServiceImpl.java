package service.before.serviceImpl;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.GoodsMapper;
import dao.OrderbaseMapper;
import dao.OrderdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Goods;
import pojo.Orderbase;
import pojo.Orderdetail;
import service.before.OrderService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/17
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderbaseMapper orderbaseMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public List<Goods> findOrderDetail(int id) {
        return goodsMapper.findOrderDetail(id);
    }

    @Override
    public void insertOrder(Orderbase orderbase) {
        orderbaseMapper.insertSelective(orderbase);
    }

    @Override
    public void updateStatus(int id) {
        orderbaseMapper.updateStatus(id);
    }

    @Override
    public int selectLastId() {
        return orderbaseMapper.selectLastId();
    }


    @Override
    public void deleteCartById(int id) {
        orderbaseMapper.deleteCartById(id);
    }

    @Override
    public List<Orderdetail> select(int last_id) {
        return orderdetailMapper.select(last_id);
    }

    @Override
    public void insertOrderDetail(Orderdetail orderdetail) {
        orderdetailMapper.insertSelective(orderdetail);
    }

    @Override
    public void updateGoodsStore(int id) {
        goodsMapper.updateGoodsStore(id);
    }
}
