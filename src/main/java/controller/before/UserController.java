package controller.before;

import com.mysql.cj.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.*;
import service.before.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/17
 */
@Controller
@RequestMapping("/user") //窄化路径，便于区分是哪个角色的访问路径
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录验证
     */
    @RequestMapping("/login")
    public String login(Buser buser,
                        Model model,
                        HttpServletRequest request)
    {
        String email = buser.getBemail();
        String password = buser.getBpwd();
        //因为是根据邮箱查询的user对象，若对象不存在则说明输入的邮箱不存在
        Buser user = userService.checkUserByEmail(email);
        if (StringUtils.isNullOrEmpty(email)){
            model.addAttribute("msg","邮箱不能为空");
            return "before/login";
        }
        else if (StringUtils.isNullOrEmpty(password)){
            model.addAttribute("msg","密码不能为空");
            return "before/login";
        }
        else if (user == null){
            model.addAttribute("msg","用户不存在");
            return "before/login";
        }
        else if (!user.getBpwd().equals(password)&&!"".equals(user.getBpwd())){
            model.addAttribute("msg","密码错误");
            return "before/login";
        }
        else {
            //存入session域，用于一次会话
            request.getSession().setAttribute("email",buser);

            request.getSession().setAttribute("buser",buser.getBemail());
        }
        return "redirect:/";
    }

    /**
     * 实现注册用户
     * 注册成功后跳转到首页
     */
    @RequestMapping("/register")
    public String register(Buser buser,
                           HttpServletRequest request)
    {
        userService.addUser(buser);
        //存入session域，用于一次会话
        request.getSession().setAttribute("email",buser);
        request.getSession().setAttribute("buser",buser.getBemail());
        return "redirect:/";
    }

    /**
     * 用户中心
     * 显示当前用户的订单、关注
     */
    @RequestMapping("/userCenter")
    public String userCenter(Model model,
                             HttpSession session)
    {
        String buserEmail = (String) session.getAttribute("buser");
        //查询该用户的订单
        List<Orderbase> list = userService.findAllOrder(buserEmail);
        model.addAttribute("myOrder",list);
        //查询该用户关注的商品 三表查询 buser\Goods\Focus
        List<Goods> list1 = userService.findFocusGoods(buserEmail);
        model.addAttribute("myFocusGoods",list1);
        return "before/userCenter";
    }

    /**
     * 用户查看商品详情
     * 接收商品的id
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(@RequestParam("id") int id,
                              Model model)
    {
        Goods goods = userService.findGoodsDetail(id);
        model.addAttribute("goods",goods);
        return "before/goodsdetail";
    }

    /**
     * 用户退出登陆
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session)
    {
        session.invalidate();
        return "before/login";
    }
}
