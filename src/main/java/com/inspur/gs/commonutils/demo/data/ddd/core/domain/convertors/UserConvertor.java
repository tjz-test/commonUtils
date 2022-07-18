package com.inspur.gs.commonutils.demo.data.ddd.core.domain.convertors;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.entity.UserEntity;

/**
 * DTO 转换器
 */
public class UserConvertor {
    /**
     * User => UserEntity
     */
    public static UserEntity convertToEntity(User user){
        UserEntity sampleEntity = new UserEntity();
        sampleEntity.setId(user.getId());
        sampleEntity.setName(user.getName());
        return sampleEntity;
    }

    /**
     * UserEntity => User
     */
    public static User convertToEmp(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        return user;
    }
}
