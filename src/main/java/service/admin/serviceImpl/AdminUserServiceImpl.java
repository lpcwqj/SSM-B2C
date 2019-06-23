package service.admin.serviceImpl;

import dao.BuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Buser;
import service.admin.AdminUserService;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 */
@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private BuserMapper buserMapper;

    @Override
    public List<Buser> findUserList() {
        return buserMapper.findUserList();
    }

    @Override
    public void deleteUser(int id) {
        buserMapper.deleteByPrimaryKey(id);
    }
}
