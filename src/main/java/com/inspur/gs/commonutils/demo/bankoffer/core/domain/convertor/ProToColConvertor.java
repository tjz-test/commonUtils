package com.inspur.gs.commonutils.demo.bankoffer.core.domain.convertor;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.core.domain.entity.ProToColNumInfo;

/**
 * @author tjz
 * @date 2022/7/15
 * @description
 */
public class ProToColConvertor {
    public static ProToColNumInfo convertToProToColNumInfo(ProcotolNumInfo procotolNumInfo) {
        ProToColNumInfo p = new ProToColNumInfo();
        p.setBankChannels(procotolNumInfo.getChannel());
        p.setBillCode(procotolNumInfo.getBillCode());
        p.setUserCode(procotolNumInfo.getUserCode());
        p.setSewageProtocolNum(procotolNumInfo.getSewageProtocolNum());
        p.setUseType(procotolNumInfo.getUseType());
        p.setWaterProtocolNum(procotolNumInfo.getWaterProtocolNum());
        return p;
    }

    public static ProcotolNumInfo convertToProcotolNumInfo(ProToColNumInfo proToColNumInfo) {
        ProcotolNumInfo p = new ProcotolNumInfo();
        p.setChannel(proToColNumInfo.getBankChannels());
        p.setBillCode(proToColNumInfo.getBillCode());
        p.setUserCode(proToColNumInfo.getUserCode());
        p.setSewageProtocolNum(proToColNumInfo.getSewageProtocolNum());
        p.setUseType(proToColNumInfo.getUseType());
        p.setWaterProtocolNum(proToColNumInfo.getWaterProtocolNum());
        return p;
    }
}
