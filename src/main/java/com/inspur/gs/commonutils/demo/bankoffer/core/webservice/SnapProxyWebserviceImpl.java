package com.inspur.gs.commonutils.demo.bankoffer.core.webservice;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.api.service.GenerateNumber;
import com.inspur.gs.commonutils.demo.bankoffer.api.webservice.SnapProxyWebservice;
import com.inspur.gs.commonutils.demo.bankoffer.core.enums.BankChannels;
import com.inspur.gs.commonutils.demo.bankoffer.core.enums.SnapDeals;
import com.inspur.gs.commonutils.demo.bankoffer.core.result.Result;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.SnapAbstractFactory;
import com.inspur.gs.commonutils.demo.bankoffer.core.factory.FactoryProducer;

/**
 * @author tjz
 * @date 2022/7/15
 * @description
 */
public class SnapProxyWebserviceImpl implements SnapProxyWebservice {

    /**
     * 生成协议号
     */
    @Override
    public Result generateNum (ProcotolNumInfo procotolNumInfo) {
        SnapAbstractFactory generateFactory = FactoryProducer.getFactory(SnapDeals.GENERATENUM.getName());
        assert generateFactory != null;
        GenerateNumber generateNumber = generateFactory.generateNumber(BankChannels.GS.getName());
        return Result.success(generateNumber.generateProcNumber(procotolNumInfo));
    }

    /**
     * 更新协议号
     */
    @Override
    public Result updateProtocolNum (ProcotolNumInfo procotolNumInfo) {
        return Result.success();
    }

    /**
     * 出盘
     */
    @Override
    public void outBount () {

    }

    /**
     * 回盘
     */
    @Override
    public void rewind () {

    }
}
