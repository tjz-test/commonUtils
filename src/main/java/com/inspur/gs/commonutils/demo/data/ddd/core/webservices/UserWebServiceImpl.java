package com.inspur.gs.commonutils.demo.data.ddd.core.webservices;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.api.entity.UserPageQuery;
import com.inspur.gs.commonutils.demo.data.ddd.api.service.UserService;
import com.inspur.gs.commonutils.demo.data.ddd.api.webservices.UserWebService;
import java.util.List;

/**
 * @author tianjinzan01
 */
public class UserWebServiceImpl implements UserWebService {

    /**
     * 用户服务
     */
    private final UserService userService;


    /**
     * 构造函数
     */
    public UserWebServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addUser(User user) {
        this.userService.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userService.updateUser(user);
    }

    @Override
    public void delUser(String id) {
        this.userService.delUser(id);
    }

    @Override
    public User getUserById(String id) {
        return this.userService.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @Override
    public UserPageQuery getUsersByPage(int pageNumber, int pageSize) {
        return this.userService.getUsersByPage(pageNumber, pageSize);
    }
}
