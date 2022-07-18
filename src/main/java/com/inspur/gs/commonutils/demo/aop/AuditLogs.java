package com.inspur.gs.commonutils.demo.aop;

import io.iec.edp.caf.audit.api.data.EventResultType;
import io.iec.edp.caf.audit.api.data.GspAudit;
import io.iec.edp.caf.audit.api.manager.GspAuditManager;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author tianjinzan01
 * @date 2022/6/24
 * @describe
 */
public class AuditLogs {
    @Pointcut(value= "execution(public * *(..))")
    public void logPointCut() { }

    @Around(value= "logPointCut()", argNames = "proceedingJoinPoint")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            //region 前置
            //保存日志
            GspAudit gspAudit = new GspAudit();
            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            //获取操作
            GspAuditLogs auditLog = method.getAnnotation(GspAuditLogs.class);
            if (auditLog != null) {
                //审计类别（必填）
                gspAudit.setCategoryId(auditLog.categoryId());
                //审计事件ID（必填）
                gspAudit.setEventId(auditLog.eventId());
                //时间（必填）
                gspAudit.setDateTime(new Date());
                //描述（必填）
                gspAudit.setDescription(auditLog.describe());
                //审计记录类型（必填）
                gspAudit.setType(auditLog.type());
                //审计事件结果（必填）
                gspAudit.setEventResult(EventResultType.success);
                //本次审计记录密级名称（可选），不赋值默认为空
                gspAudit.setSecretLevel("一般");
                //本次审计记录密级名称（可选），0.2.7版本支持传递密级id，根据gspsecuritylevel表中数据记录密级，优先级高于SecretLevel属性
                gspAudit.setSecretId("INTERNAL");
            }

            //region 启动目标方法执行
            proceedingJoinPoint.proceed();
            //endregion

            //region 后置
            GspAuditManager auditManager = SpringBeanUtils.getBean(GspAuditManager.class);
            auditManager.addAuditSync(gspAudit);
            //endregion

            return "";
        } catch (Throwable e) {
            throw e;
        }
    }
}
