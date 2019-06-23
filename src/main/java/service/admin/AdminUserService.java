package service.admin;

import pojo.Buser;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/6/16
 *
 * 业务逻辑层 管理员管理用户
 */
public interface AdminUserService {

    /**
     * 查询用户列表
     */
    List<Buser> findUserList();

    /**
     * 删除用户
     * @param id 前台传来的参数 id
     */
    void deleteUser(int id);
}
