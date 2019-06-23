package controller.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Goods;
import service.before.GoodsService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/19
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 模糊查询
     * @param goodsTypeName 前台传来的模糊商品类型名
     */
    @RequestMapping("/search")
    public String search(@RequestParam("mykey") String goodsTypeName,
                         Model model)
    {
        List<Goods> list = goodsService.Search(goodsTypeName);
        model.addAttribute("searchlist",list);
        return "before/searchResult";
    }

    /**
     * 接收商品类型id
     * 查询该商品类型对应的全部商品
     */
    @RequestMapping("/before")
    public String before(@RequestParam("id") int id,
                         Model model)
    {
        if (id==0){ //点击首页
            return "forward:/";
        }
        List<Goods> list = goodsService.findGoodsList(id);
        model.addAttribute("searchlist",list);
        return "before/searchResult";
    }
}
