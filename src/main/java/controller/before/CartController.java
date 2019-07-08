package controller.before;

import dao.BuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Cart;
import pojo.Focus;
import pojo.Goods;
import service.before.CartService;
import service.before.FocusService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/18
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BuserMapper buserMapper;
    @Autowired
    private FocusService focusService;

    /**
     * 查询显示该用户的购物车的全部信息
     */
    @RequestMapping("/selectCart")
    public String selectCart(Model model,
                             HttpSession session)
    {
        //查询用户id
        String email =(String) session.getAttribute("buser");
        int id = buserMapper.selectId(email);
        List<Goods> list = cartService.selectCart(id);
        model.addAttribute("cartlist",list);
        double total = 0;
        for (Goods goods:list) {
            total += goods.getSmallsum();
        }
        model.addAttribute("total",total);
        return "/before/cart";
    }

    /**
     * 将商品添加到购物车
     * 用户id  自查
     * 商品id  接收前台参数
     * 购买数量 接收前台参数
     */
    @RequestMapping("/putCart")
    public String putCart(@RequestParam("id") int goodsId,
                          @RequestParam("shoppingnum") int shoppingnum,
                          HttpSession session)
    {
        //查询用户id
        String email =(String) session.getAttribute("buser");
        int id = buserMapper.selectId(email);
        //封装
        Cart cart = new Cart();
        cart.setBuserId(id);
        cart.setGoodsId(goodsId);
        cart.setShoppingnum(shoppingnum);
        //添加购物车
        cartService.insert(cart);
        return "redirect:/cart/selectCart";
    }

    /**
     * 删除该用户的购物车中的指定商品
     * 根据商品id 和 用户id
     */
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(@RequestParam("id")int id,
                               HttpSession session)
    {
        //查询用户id
        String email =(String) session.getAttribute("buser");
        int user_id = buserMapper.selectId(email);

        cartService.deleteById(id,user_id);
        return "redirect:/cart/selectCart";
    }

    /**
     * 清空该用户的购物车
     */
    @RequestMapping("/clear")
    public String clear(HttpSession session)
    {
        //查询用户id
        String email =(String) session.getAttribute("buser");
        int id = buserMapper.selectId(email);

        cartService.deleteCart(id);
        return "redirect:/cart/selectCart";
    }

    /**
     * 点击'去结算' 跳转到确定订单页面
     * 将该用户的购物车里的商品信息 显示到确认订单信息页面
     */
    @RequestMapping("/orderConfirm")
    public String orderConfirm(Model model,
                               HttpSession session)
    {
        //查询用户id
        String email =(String) session.getAttribute("buser");
        int id = buserMapper.selectId(email);

        List<Goods> list = cartService.selectCart(id);
        model.addAttribute("cartlist",list);
        double total = 0;
        for (Goods goods:list) {
            total += goods.getSmallsum();
        }
        model.addAttribute("total",total);
        return "before/orderconfirm";
    }

    /**
     * 继续购物
     * 跳转到首页
     */
    @RequestMapping("/continue")
    public String continueShopping()
    {
        return "redirect:/";
    }

    /**
     * 接收商品id
     * 将商品添加到关注列表里
     * 后跳转到用户中心
     */
    @RequestMapping("/focus")
    public String focus(@RequestParam("id") int id,
                        HttpSession session)
    {
        //查询用户id
        String email =(String) session.getAttribute("buser");
        int buser_id = buserMapper.selectId(email);
        Date date = new Date();
        //封装
        Focus focus = new Focus();
        focus.setBuserId(buser_id);
        focus.setFocustime(date);
        focus.setGoodsId(id);
        focusService.insertFocus(focus);
        return "redirect:/user/userCenter";
    }
}
