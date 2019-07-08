package service.admin.serviceImpl;

import dao.AuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Auser;
import service.admin.AdminLoginService;

/**
 * @author Lin
 * @Date 2019/6/17
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private AuserMapper auserMapper;

    @Override
    public Auser checkUserByUsername(String username) {

        return auserMapper.checkUserByUsername(username);

    }
}
