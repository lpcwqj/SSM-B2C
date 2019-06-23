package service.before.serviceImpl;

import dao.FocusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Focus;
import service.before.FocusService;

/**
 * @author Lin
 * @Date 2019/6/20
 */
@Service
public class FocusServiceImpl implements FocusService {
    @Autowired
    private FocusMapper focusMapper;

    @Override
    public void insertFocus(Focus focus) {
        focusMapper.insertSelective(focus);
    }
}
