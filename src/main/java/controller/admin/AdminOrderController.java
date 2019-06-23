package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Orderbase;
import service.admin.AdminOrderService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController {
    @Autowired
    private AdminOrderService adminOrderService;

    /**
     * 跳转到删除订单页面
     */
    @RequestMapping("/orderInfo")
    public String orderInfo(Model model)
    {
        List<Orderbase> list = adminOrderService.findOrderList();
        model.addAttribute("orderList",list);
        return "admin/orderManager";
    }

    /**
     * 删除订单
     *
     * 因为订单基础表和订单详情表关联
     * 所以 先删除该订单的订单详情 再删除该订单(先删除外键约束)
     * 但是 在建表时设置外键约束时cascade,即删除主键时相应的外键列也被删除
     */
    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("id") int id)
    {
        adminOrderService.deleteOrderById(id);
        return "redirect:/adminOrder/orderInfo";
    }
}
