package service.before.serviceImpl;

import dao.CartMapper;
import dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Cart;
import pojo.Goods;
import service.before.CartService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/18
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void insert(Cart cart) {
        cartMapper.insertSelective(cart);
    }

    @Override
    public void deleteById(int id) {
        cartMapper.deleteById(id);
    }

    @Override
    public List<Goods> selectCart() {
        return cartMapper.selectCart();
    }

    @Override
    public void deleteCart() {
        cartMapper.deleteCart();
    }
}
