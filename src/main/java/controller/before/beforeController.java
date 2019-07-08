package controller.before;

import dao.GoodstypeMapper;
import dao.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Goods;
import pojo.Goodstype;
import pojo.Notice;
import service.before.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/20
 */
@Controller
public class beforeController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodstypeMapper goodstypeMapper;
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     *  设置访问根目录为index.jsp
     */
    @RequestMapping("/")
    public String home(Model model,
                       HttpSession session)
    {
        //查询商品类型
        List<Goodstype> list = goodstypeMapper.selectGoodsType();
        session.setAttribute("goodsType",list);

        //查询销售排行  orderdetail表中按shoppingnum的大小排列
        List<Goods> list1 = userService.selectOrderByShoppingNum();
        model.addAttribute("salelist",list1);

        //查询人气排行  focus表中按goods_id出现的次数排列
        List<Goods> list2 = userService.selectPeopleHot();
        model.addAttribute("focuslist",list2);

        //查询公告
        List<Notice> list3 = noticeMapper.findAllNotice();
        model.addAttribute("noticelist",list3);

        //查询最新商品  根据id降序查询  只显示15个
        List<Goods> list4 = userService.selectAllGoods();
        model.addAttribute("lastedlist",list4);

        return "before/index";
    }
}
