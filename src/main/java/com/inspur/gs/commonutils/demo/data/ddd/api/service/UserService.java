package com.inspur.gs.commonutils.demo.data.ddd.api.service;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.api.entity.UserPageQuery;
import java.util.List;

public interface UserService {
    /**
     * Add an user
     * @param user
     */
    void addUser(User user);

    /**
     * Update an user
     * @param sample
     */
    void updateUser(User sample);

    /**
     * Delete an User
     * @param id
     */
    void delUser(String id);

    /**
     * Get an User
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * Get all User
     * @return
     */
    List<User> getAllUsers();

    /**
     * Get employees and pagination info
     * @param pageNumber
     * @param pageSize
     * @return
     */
    UserPageQuery getUsersByPage(int pageNumber, int pageSize);
}
