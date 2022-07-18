package com.inspur.gs.commonutils.demo.data.ddd.api.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * @author tianjinzan01
 */
@Setter
@Getter
public class UserPageQuery {

    /**
     * The list of user
     */
    private List<User> userList;


    /**
     * The total count of user
     */
    private int totalNumber;
}
