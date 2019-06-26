package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Notice;
import service.admin.AdminNoticeService;

import java.util.Date;
import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController {
    @Autowired
    private AdminNoticeService adminNoticeService;

    /**
     * 跳转到添加公告页面
     */
    @RequestMapping("toAddNotice")
    public String toAddNotice(Model model)
    {
        model.addAttribute("notice",new Notice());
        return "admin/addNotice";
    }

    /**
     * 添加公告
     */
    @RequestMapping("/addNotice")
    public String addNotice(@ModelAttribute("notice")Notice notice)
    {
        notice.setNtime(new Date());
        adminNoticeService.addNotice(notice);
        return "redirect:/adminNotice/toAddNotice";
    }

    /**
     * 删除公告
     * 1.先查询所有
     */
    @RequestMapping("/deleteNotice")
    public String deleteNotice(Model model)
    {
        List<Notice> list = adminNoticeService.findAllNotice();
        model.addAttribute("allNotices",list);
        return "admin/deleteNoticeSelect";
    }
    /**
     * 删除公告
     * 2.删除
     */
    @RequestMapping("/deleteNoticeSelect")
    public String deleteNoticeSelect(@RequestParam("id") int id)
    {
        adminNoticeService.deleteNotice(id);
        return "redirect:/adminNotice/deleteNotice";
    }
}
