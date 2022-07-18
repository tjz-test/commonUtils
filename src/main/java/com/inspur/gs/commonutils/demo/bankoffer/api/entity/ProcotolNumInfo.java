package com.inspur.gs.commonutils.demo.bankoffer.api.entity;

import com.inspur.gs.commonutils.demo.bankoffer.core.enums.BankChannels;
import com.inspur.gs.commonutils.demo.bankoffer.core.enums.UseType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tjz
 * @date 2022/7/14
 * @description
 */
@Getter
@Setter
public class ProcotolNumInfo {
    /**
     * 渠道
     */
    private BankChannels channel;

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
    private UseType useType;
}
