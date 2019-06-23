package service.admin;

import pojo.Notice;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 *
 * 业务逻辑层 管理员管理公告
 */
public interface AdminNoticeService {
    /**
     * 添加公告
     * @param notice
     */
    void addNotice(Notice notice);

    /**
     * 删除公告
     * @param id
     */
    void deleteNotice(int id);

    /**
     * 查询所有公告
     * @return
     */
    List<Notice> findAllNotice();

    /**
     * 查看一个公告的详情
     * @param id
     * @return
     */
    Notice findNoticeById(int id);
}
