package com.inspur.gs.commonutils.demo.bankoffer.core.service;

import com.inspur.gs.commonutils.demo.bankoffer.api.service.GenerateNumber;
import com.inspur.gs.commonutils.demo.bankoffer.api.service.OutBound;
import com.inspur.gs.commonutils.demo.bankoffer.api.service.Rewind;

/**
 * @author tjz
 * @date 2022/7/14
 * @description 批扣抽象工厂
 */
public abstract class SnapAbstractFactory {
    /**
     * 协议号
     */
    public abstract GenerateNumber generateNumber(String type);

    /**
     * 出盘
     */
    public abstract OutBound getOutBound(String type);

    /**
     * 回盘
     */
    public abstract Rewind getRewind(String type);
}
