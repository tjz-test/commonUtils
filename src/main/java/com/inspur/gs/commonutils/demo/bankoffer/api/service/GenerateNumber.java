package com.inspur.gs.commonutils.demo.bankoffer.api.service;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;

/**
 * @author tjz
 * @date 2022/7/14
 * @description 生成协议号
 */
public interface GenerateNumber {
    /**
     * 生成协议号
     * @return 协议号
     */
    String generateProcNumber(ProcotolNumInfo procotolNumInfo);

    /**
     * 协议号更新
     */
    String updateProcNumber(ProcotolNumInfo procotolNumInfo);
}
