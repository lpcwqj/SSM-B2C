package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Buser;
import service.admin.AdminUserService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 跳转到用户管理页面
     */
    @RequestMapping("userInfo")
    public String userInfo(Model model)
    {
        List<Buser> list = adminUserService.findUserList();
        model.addAttribute("userList",list);
        return "admin/userManager";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id)
    {
        adminUserService.deleteUser(id);
        return "redirect:/adminUser/userInfo";
    }
}
