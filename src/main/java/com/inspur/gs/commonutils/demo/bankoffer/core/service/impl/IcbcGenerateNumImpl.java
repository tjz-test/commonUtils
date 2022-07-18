package com.inspur.gs.commonutils.demo.bankoffer.core.service.impl;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.api.service.GenerateNumber;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.DataService;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;

/**
 * @author tjz
 * @date 2022/7/14
 * @description 工商银行生成协议号
 */
public class IcbcGenerateNumImpl implements GenerateNumber {

    private final DataService dataService;

    public IcbcGenerateNumImpl() {
        this.dataService = (DataService) SpringBeanUtils.getBean("gsxmciSnapDataService");
    }

    /**
     * 生成协议号
     */
    @Override
    public String generateProcNumber(ProcotolNumInfo procotolNumInfo) {
        //发起申请生成协议号
        String sewageProToColNum = "";
        String waterProToColNum = "";
        procotolNumInfo.setSewageProtocolNum(sewageProToColNum);
        procotolNumInfo.setWaterProtocolNum(waterProToColNum);
        this.dataService.addProToColNumber(procotolNumInfo);
        return "";
    }

    /**
     * 协议号更新
     */
    @Override
    public String updateProcNumber (ProcotolNumInfo procotolNumInfo) {
        return null;
    }
}
