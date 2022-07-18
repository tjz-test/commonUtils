package com.inspur.gs.commonutils.demo.bankoffer.core.domain.manager;

import com.inspur.gs.commonutils.demo.bankoffer.api.entity.ProcotolNumInfo;
import com.inspur.gs.commonutils.demo.bankoffer.core.domain.convertor.ProToColConvertor;
import com.inspur.gs.commonutils.demo.bankoffer.core.domain.repository.ProToColNumRepository;
import lombok.var;

/**
 * @author tjz
 * @date 2022/7/15
 * @description
 */
public class ProToColNumManager {

    /**
     * 注入资源库
     */
    ProToColNumRepository proToColNumRepository;

    /**
     * Constructor
     */
    public ProToColNumManager(ProToColNumRepository proToColNumRepository) {
        this.proToColNumRepository = proToColNumRepository;
    }

    public void addProtoColNum(ProcotolNumInfo procotolNumInfo) {
        var proToCplInfo = ProToColConvertor.convertToProToColNumInfo(procotolNumInfo);
        this.proToColNumRepository.save(proToCplInfo);
    }
}
