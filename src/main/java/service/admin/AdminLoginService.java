package service.admin;

import pojo.Auser;

/**
 * @author Lin
 * @Date 2019/6/17
 */
public interface AdminLoginService {
    /**
     * 根据输入的用户名检查数据库中是否存在该用户
     * @param username
     */
    Auser checkUserByUsername(String username);
}
