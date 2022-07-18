package com.inspur.gs.commonutils.demo.aop;

import io.iec.edp.caf.audit.api.data.AuditType;

import java.lang.annotation.*;

/**
 * @author tianjinzan01
 * @date 2022/6/24
 * @describe
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GspAuditLogs {
    /**
     * 审计类别ID
     * @return
     */
    String categoryId();

    /**
     * 审计事件ID
     * @return
     */
    String eventId();

    /**
     * 描述
     * @return
     */
    String describe();

    /**
     * 审计记录类型
     * @return
     */
    AuditType type();
}

