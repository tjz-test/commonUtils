package com.inspur.gs.commonutils.demo.data.ddd.core.domain.managers;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.api.entity.UserPageQuery;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.convertors.UserConvertor;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.entity.UserEntity;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.repository.UserRepositoryTestDemo;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UserManager
 * @author tianjinzan01
 */
public class UserManager {
    /**
     * UserRepository
     */
    UserRepositoryTestDemo userRepository;

    /**
     * Constructor
     */
    public UserManager(UserRepositoryTestDemo userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Add
     */
    public void addUser(User user) {
        var userEntity = UserConvertor.convertToEntity(user);
        this.userRepository.save(userEntity);
    }

    /**
     * Update
     */
    public void updateUser(User user) {
        var userEntity = this.userRepository.findById(user.getId()).isPresent() ? this.userRepository.findById(user.getId()).get() : null;
        if (Optional.ofNullable(userEntity).isPresent()) {
            this.userRepository.save(userEntity);
        }
    }

    /**
     * Delete
     */
    public void delUser(String id) {
        this.userRepository.deleteById(id);
    }

    /**
     * Get
     */
    public User getUserById(String id) {
        var userEntity = this.userRepository.findById(id).isPresent() ? this.userRepository.findById(id).get() : null;
        assert userEntity != null;
        return UserConvertor.convertToEmp(userEntity);
    }

    /**
     * GetAll
     */
    public List<User> getAllUsers() {
        var userEntities = this.userRepository.findAll();
        var userList = new ArrayList<User>();

        for (var userEntity : userEntities) {
            var user = UserConvertor.convertToEmp(userEntity);
            userList.add(user);
        }
        return userList;
    }

    /**
     * GetByPage
     */
    public UserPageQuery getUsersByPage(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<UserEntity> pageResult = this.userRepository.findAll(pageable);

        UserPageQuery userPageQuery = new UserPageQuery();
        userPageQuery.setTotalNumber(pageResult.getTotalPages());

        var userList = new ArrayList<User>();
        for (var userEntity : pageResult) {
            var user = UserConvertor.convertToEmp(userEntity);
            userList.add(user);
        }

        userPageQuery.setUserList(userList);
        return userPageQuery;
    }
}
