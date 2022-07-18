package com.inspur.gs.commonutils.demo.bankoffer.core.service.impl;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.core.domain.manager.ProToColNumManager;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.DataService;

/**
 * @author tjz
 * @date 2022/7/15
 * @description
 */
public class DataServiceImpl implements DataService {

    ProToColNumManager proToColNumManager;

    public DataServiceImpl(ProToColNumManager proToColNumManager) {
        this.proToColNumManager = proToColNumManager;
    }

    @Override
    public void addProToColNumber (ProcotolNumInfo procotolNumInfo) {
        this.proToColNumManager.addProtoColNum(procotolNumInfo);
    }
}
