package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Goods;
import pojo.Goodstype;
import pojo.Orderdetail;
import service.admin.AdminGoodsService;
import utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Lin
 * @Date 2019/6/14
 */
@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController {
    @Autowired
    private AdminGoodsService adminGoodsService;

    /**
     * 分页
     * 查询 修改 删除商品
     */
    @RequestMapping("/selectGoods")
    public String selectGoods(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                              @RequestParam(value = "act",required = false)String act,
                              Model model)
    {
        PageUtils<Goods> page = adminGoodsService.selectGoods(currentPage);
        model.addAttribute("allGoods",page);
        if ("updateSelect".equals(act)){
            return "admin/updateSelectGoods";
        }
        if ("deleteSelect".equals(act)){
            return "admin/deleteSelectGoods";
        }
        return "admin/selectGoods";
    }
    /**
     * 跳转到添加商品页面
     */
    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model)
    {
        model.addAttribute("goods",new Goods());

        List<Goodstype> goodsType = adminGoodsService.findGoodsTypeName();
        model.addAttribute("goodsType",goodsType);

        return "admin/addGoods";
    }
    /**
     * 添加或修改商品
     *
     *    上传图片：tomcat需要添加一个物理路径
     *    前台编辑页面回显图片的路径要和tomcat的虚拟路径相同。tomcat中需要设置图片的真实路径
     */
    @RequestMapping("/addGoods")
    public String addGoods(Goods goods,
                           @RequestParam(value = "updateAct",required = false) String updateAct,
                           MultipartFile logoImage) throws IOException
    {
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = logoImage.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        // 开始上传
        logoImage.transferTo(new File("E:/upload/" + picName + extName));
        // 设置图片名到商品中
        goods.setGpicture(picName + extName);
        if ("update".equals(updateAct)){
            adminGoodsService.updateGoods(goods);
            return "redirect:/adminGoods/selectGoods";
        }
        adminGoodsService.addGoods(goods);
        return "redirect:/adminGoods/selectGoods";
    }
    /**
     * 修改商品时的回显数据和查询商品详情
     * 都是根据id进行查询
     */
    @RequestMapping("/selectAGoods")
    public String selectAGoods(@RequestParam("id")int id,
                               @RequestParam(value = "act",required = false)String act,
                               Model model){
        //根据id查询商品信息 回显数据
        Goods goodsById = adminGoodsService.findGoodsById(id);
        model.addAttribute("goods",goodsById);

        String goodsTypeName = adminGoodsService.findGoodsTypeNameById(id);
        model.addAttribute("goodsTypeName",goodsTypeName);

        if ("updateAgoods".equals(act)){
            List<Goodstype> goodsType = adminGoodsService.findGoodsTypeName();
            model.addAttribute("goodsType",goodsType);
            return "admin/updateAgoods";
        }
        return "admin/goodsDetail";
    }
    /**
     * 删除一个商品
     *  要注意 如果某个订单中存在该商品 则不允许删除该商品
     */
    @RequestMapping("/deleteAGoods")
    public String deleteAGoods(@RequestParam("id") int id,
                               Model model)
    {
        Orderdetail orderdetails = adminGoodsService.findIfHaveGoods(id);
        if (orderdetails!=null){
            model.addAttribute("message","商品有关联，不允许删除");
            return "admin/deleteSelectGoods";
        }
        else{
            adminGoodsService.deleteAGoods(id);
        }
        return "redirect:/adminGoods/selectGoods";
    }
    /**
     * 批量删除
     *  要注意 如果某个订单中存在该商品 则不允许删除该商品
     */
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Integer[] ids,
                              Model model)
    {
        List<Orderdetail> orderdetails = adminGoodsService.findIfHaveGoodsByIds(ids);
        if (orderdetails!=null){
            model.addAttribute("message","商品有关联，不允许删除");
            return "admin/deleteSelectGoods";
        }
        else{
            adminGoodsService.deleteGoods(ids);
        }
        return "redirect:/adminGoods/selectGoods";
    }
}
