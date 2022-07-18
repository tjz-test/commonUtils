package com.inspur.gs.commonutils.demo.aop;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class SysOperLog {
    private String title;
    private Integer businessType;
    private String method;
    private String operParam;
    private String operName;
    private Date operTime;
    private String operIp;
    private String operUrl;
}
