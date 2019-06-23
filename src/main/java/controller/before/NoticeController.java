package controller.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Notice;
import service.admin.AdminNoticeService;

/**
 * @author Lin
 * @Date 2019/6/21
 */
@Controller
public class NoticeController {
    @Autowired
    private AdminNoticeService adminNoticeService;

    /**
     * 查询公告详情
     */
    @RequestMapping("/selectANotice")
    public String selectANotice(@RequestParam("id") int id,
                                Model model)
    {
        Notice notice = adminNoticeService.findNoticeById(id);
        model.addAttribute("notice",notice);
        return "admin/noticeDetail";
    }
}
