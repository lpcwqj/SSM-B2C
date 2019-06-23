package service.admin.serviceImpl;

import dao.OrderbaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Orderbase;
import service.admin.AdminOrderService;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Service
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    private OrderbaseMapper orderbaseMapper;

    @Override
    public List<Orderbase> findOrderList() {
        return orderbaseMapper.findOrderList();
    }

    @Override
    public void deleteOrderById(int id) {
        orderbaseMapper.deleteByPrimaryKey(id);

    }
}
