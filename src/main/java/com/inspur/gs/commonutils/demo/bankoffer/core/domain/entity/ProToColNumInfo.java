package com.inspur.gs.commonutils.demo.bankoffer.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inspur.gs.commonutils.demo.bankoffer.core.enums.BankChannels;
import com.inspur.gs.commonutils.demo.bankoffer.core.enums.UseType;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author tjz
 * @date 2022/7/15
 * @description 协议号信息表
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table (name = "gsxmciprotocolnumberinfo",
        uniqueConstraints = {@UniqueConstraint(name = "uc_protocolnuminfo_id", columnNames = {"id"})})
@EntityListeners(AuditingEntityListener.class)
@Accessors (chain = true)

public class ProToColNumInfo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;

    /**
     * 版本日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreatedDate
    private Date version;

    /**
     * 渠道
     */
    @Enumerated
    @Column (name = "bankchannels")
    private BankChannels bankChannels;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 结算户号
     */
    private String billCode;

    /**
     * 污水协议号
     */
    private String sewageProtocolNum;

    /**
     * 水协议号
     */
    private String waterProtocolNum;

    /**
     * 使用状态
     */
    @Enumerated
    @Column (name = "usetype")
    private UseType useType;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ProToColNumInfo that = (ProToColNumInfo) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
