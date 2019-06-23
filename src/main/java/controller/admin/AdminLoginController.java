package controller.admin;

import com.mysql.cj.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Auser;
import service.admin.AdminLoginService;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Lin
 * @Date 2019/6/17
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    @Autowired
    private AdminLoginService adminLoginService;


    /**
     * 管理员登陆验证
     */
    @RequestMapping("/login")
    public String login(@RequestParam("aname") String username,
                        @RequestParam("apwd") String password,
                        HttpServletRequest request,
                        Model model)
    {
        if (StringUtils.isNullOrEmpty(username)){
            model.addAttribute("msg","用户名不能为空");
            return "/admin/login";
        }
        if (StringUtils.isNullOrEmpty(password)){
            model.addAttribute("msg","密码不能为空");
            return "/admin/login";
        }
        //因为是根据用户名查询的user集合，若集合不存在则说明输入的用户名不存在
        Auser user = adminLoginService.checkUserByUsername(username);
        if (user == null){
            model.addAttribute("msg","用户不存在");
            return "/admin/login";
        }
        else if (!user.getApwd().equals(password)&&!"".equals(user.getApwd())){
            model.addAttribute("msg","密码错误");
            return "/admin/login";
        }
        //存入session域，用于一次会话
        request.getSession().setAttribute("adminname",username);
        model.addAttribute("aname",username);
        return "admin/main";
    }

    /**
     * 管理员退出登录
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return "admin/main";
    }
}
