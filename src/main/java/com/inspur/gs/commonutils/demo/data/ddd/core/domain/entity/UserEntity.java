package com.inspur.gs.commonutils.demo.data.ddd.core.domain.entity;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Data
@Entity
@Table(name = "userdemo")
@Accessors(chain = true)

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_ID")
    @SequenceGenerator(name = "SEQ_USER_ID", sequenceName = "SEQ_USER_ID")
    private String id;

    private String name;

    private String address;

    private Integer age;
}
