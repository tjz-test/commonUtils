package com.inspur.gs.commonutils.demo.data.ddd.api.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tianjinzan01
 * DDD 领域驱动设计模式
 * PO -> DO -> DTO -> VO
 */
@Getter
@Setter
public class User {

    private String id;

    private String name;
}
