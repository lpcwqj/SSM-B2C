package service.admin.serviceImpl;

import dao.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Notice;
import service.admin.AdminNoticeService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Service
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.insertSelective(notice);
    }

    @Override
    public void deleteNotice(int id) {
        noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Notice> findAllNotice() {
        return noticeMapper.findAllNotice();
    }

    @Override
    public Notice findNoticeById(int id) {
        return noticeMapper.selectByPrimaryKey(id);
    }
}
