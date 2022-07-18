package com.inspur.gs.commonutils.demo.bankoffer.core.factory;

import com.inspur.gs.commonutils.demo.bankoffer.core.enums.SnapDeals;
import com.inspur.gs.commonutils.demo.bankoffer.core.service.SnapAbstractFactory;

/**
 * @author tjz
 * @date 2022/7/14
 * @description 超级工厂
 */
public class FactoryProducer {

    public static SnapAbstractFactory getFactory (String choice){
        if(choice.equalsIgnoreCase(SnapDeals.GENERATENUM.getName())){
            return new GenerateNumFactory();
        } else if(choice.equalsIgnoreCase(SnapDeals.OUTBOUND.getName())){
            return new OutBoundFactory();
        } else if(choice.equalsIgnoreCase(SnapDeals.REWIND.getName())){
            return new RewindFactory();
        }
        return null;
    }
}
