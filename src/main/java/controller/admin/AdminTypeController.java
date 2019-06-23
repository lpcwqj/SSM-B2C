package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Goodstype;
import service.admin.AdminTypeService;
import utils.PageUtils;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Controller
@RequestMapping("/adminType")
public class AdminTypeController {
    @Autowired
    private AdminTypeService adminTypeService;

    /**
     * 跳转到添加商品类型页面
     * 分页显示
     */
    @RequestMapping("/toAddType")
    public String toAddType(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                            Model model)
    {
        PageUtils<Goodstype> goodsType = adminTypeService.selectGoodsType(currentPage);
        model.addAttribute("allTypes",goodsType);
        return "admin/addType";
    }

    /**
     * 添加商品类型
     */
    @RequestMapping("/addType")
    public String addType(Goodstype goodstype)
    {
        adminTypeService.addType(goodstype);
        return "redirect:/adminType/toAddType";
    }

    /**
     * 跳转到删除商品类型页面
     * 分页显示
     */
    @RequestMapping("/toDeleteType")
    public String toDeleteType(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                               Model model)
    {
        PageUtils<Goodstype> goodsType = adminTypeService.selectGoodsType(currentPage);
        model.addAttribute("allTypes",goodsType);
        return "admin/deleteType";
    }

    /**
     * 删除商品类型
     */
    @RequestMapping("/deleteType")
    public String deleteType(@RequestParam("id") int id)
    {
        adminTypeService.deleteTypeById(id);
        return "redirect:/adminType/toAddType";
    }
}
