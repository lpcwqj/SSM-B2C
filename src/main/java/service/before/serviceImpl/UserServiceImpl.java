package service.before.serviceImpl;

import dao.BuserMapper;
import dao.FocusMapper;
import dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Buser;
import pojo.Goods;
import pojo.Orderbase;
import service.before.UserService;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/17
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BuserMapper buserMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Buser checkUserByEmail(String email) {
        return buserMapper.checkUserByEmail(email);
    }

    @Override
    public void addUser(Buser buser) {
        buserMapper.insertSelective(buser);
    }

    @Override
    public List<Orderbase> findAllOrder(String buserEmail) {
        return buserMapper.findAllOrder(buserEmail);
    }

    @Override
    public List<Goods> findFocusGoods(String buserEmail) {
        return goodsMapper.findFocusGoods(buserEmail);
    }

    @Override
    public Goods findGoodsDetail(int id) {
        return goodsMapper.findGoodsDetail(id);
    }

    @Override
    public List<Goods> selectOrderByShoppingNum() {
        return goodsMapper.selectOrderByShoppingNum();
    }

    @Override
    public List<Goods> selectPeopleHot() {
        return goodsMapper.selectPeopleHot();
    }

    @Override
    public List<Goods> selectAllGoods() {
        return goodsMapper.findAllGoods();
    }

}
