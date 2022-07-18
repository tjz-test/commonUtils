package com.inspur.gs.commonutils.demo.bankoffer.core.factory;

import com.inspur.gs.commonutils.demo.bankoffer.api.service.GenerateNumber;
import com.inspur.gs.commonutils.demo.bankoffer.api.service.OutBound;
import com.inspur.gs.commonutils.demo.bankoffer.api.service.Rewind;
import com.inspur.gs.commonutils.demo.bankoffer.core.enums.BankChannels;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.SnapAbstractFactory;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.impl.IcbcGenerateNumImpl;
import com.inspur.gs.commonutils.stringutil.StringUtils;

/**
 * @author tjz
 * @date 2022/7/14
 * @description
 */
public class GenerateNumFactory extends SnapAbstractFactory {

    /**
     * 协议号
     * @param type 银行渠道
     */
    @Override
    public GenerateNumber generateNumber (String type) {
        if (StringUtils.IsNullOrEmpty(type)) {
            return null;
        }
        if (type.equalsIgnoreCase(BankChannels.GS.getName ())) {
            return new IcbcGenerateNumImpl();
        }
        return null;
    }

    /**
     * 出盘
     * @param type 银行渠道
     */
    @Override
    public OutBound getOutBound (String type) {
        return null;
    }

    /**
     * 回盘
     * @param type 银行渠道
     */
    @Override
    public Rewind getRewind (String type) {
        return null;
    }
}
