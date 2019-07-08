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
    public void deleteById(int id,int user_id) {
        cartMapper.deleteById(id,user_id);
    }

    @Override
    public List<Goods> selectCart(int id) {
        return cartMapper.selectCart(id);
    }

    @Override
    public void deleteCart(int id) {
        cartMapper.deleteCart(id);
    }
}
