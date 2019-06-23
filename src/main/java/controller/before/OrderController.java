package controller.before;

import dao.BuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Goods;
import pojo.Orderbase;
import pojo.Orderdetail;
import service.before.OrderService;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/17
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuserMapper buserMapper;

    /**
     * 根据订单id查询订单详情
     * 商品的详情和购买数量
     * 接收订单的id
     */
    @RequestMapping("/orderDetail")
    public String orderDetail(@RequestParam("ordersn") int id,
                              Model model)
    {
        List<Goods> list = orderService.findOrderDetail(id);
        model.addAttribute("myOrderDetail",list);
        return "before/userOrderDetail";
    }

    /**
     * 点击'去支付'
     *  接收订单的id
     * 跳转到支付页面
     */
    @RequestMapping("/pay")
    public String pay(@RequestParam("ordersn") int id,
                      Model model)
    {
        model.addAttribute("ordersn",id);
        return "before/orderdone";
    }

    /**
     * 点击确认提交订单后(需要注意两点：1、2、3)
     * 1.添加订单数据(订单状态是未支付0)
     * 2.添加订单详情数据 (根据购物车、订单 两表数据进行添加)
     * 3.删除该订单包含的购物车信息
     *
     * 一个订单包含一条订单信息
     * 一个订单详情包含购物车中的全部商品信息
     * 一个购物车可以有多条商品
     * 1：N：N
     *
     * 订单创建完成 立马获取其id 用于订单完成页面的显示
     */
    @RequestMapping("/orderSubmit")
    public String orderSubmit(@RequestParam("amount") double amount,
                              HttpSession session,
                              Model model)
    {
        // 1.
        String email =(String) session.getAttribute("buser");
        int id = buserMapper.selectId(email);
        Byte status = 0;
        Date date = new Date();
        //封装
        Orderbase orderbase = new Orderbase();
        orderbase.setAmount(amount);
        orderbase.setBuserId(id);
        orderbase.setStatus(status);
        orderbase.setOrderstate(date);
        orderService.insertOrder(orderbase);
        // 2.
        //立马获得刚插入的订单id 因为id自增 即查询最大的id
        int last_id = orderService.selectLastId();
        model.addAttribute("ordersn",last_id);
        //根据购物车、订单 两表数据查询
        List<Orderdetail> list = orderService.select(last_id);
        //添加订单详情  遍历集合  依次添加
        for (Orderdetail orderdetail:list) {
            orderService.insertOrderDetail(orderdetail);
        }
        //删除该订单对应的购物车信息
        orderService.deleteCartById(last_id);
        return "before/orderdone";
    }

    /**
     * 支付成功的跳转页面(需要注意 1、2)
     * 1. 接收订单id更新订单的状态为已支付1
     * 2. 商品库存随之减少 (商品 订单 订单详情三表联合更新)
     */
    @RequestMapping("/payDone")
    public String paydone(@RequestParam("ordersn") int id)
    {
        // 1.
        orderService.updateStatus(id);
        // 2.
        orderService.updateGoodsStore(id);
        return "before/paydone";
    }
}
