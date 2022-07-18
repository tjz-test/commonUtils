package com.inspur.gs.commonutils.demo.data.ddd.core.service;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.api.entity.UserPageQuery;
import com.inspur.gs.commonutils.demo.data.ddd.api.service.UserService;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.managers.UserManager;

import java.util.List;

/**
 * @author tianjinzan01
 */
public class UserServiceImpl implements UserService {

    /**
     * Manager
     */
    UserManager userManager;

    /**
     * Constructor
     */
    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }


    @Override
    public void addUser(User user) {
        this.userManager.addUser(user);
    }

    @Override
    public void updateUser(User sample) {
        this.userManager.updateUser(sample);
    }

    @Override
    public void delUser(String id) {
        this.userManager.delUser(id);
    }

    @Override
    public User getUserById(String id) {
        return this.userManager.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userManager.getAllUsers();
    }

    @Override
    public UserPageQuery getUsersByPage(int pageNumber, int pageSize) {
        return this.userManager.getUsersByPage(pageNumber, pageSize);
    }
}
