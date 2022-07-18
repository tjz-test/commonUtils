package com.inspur.gs.commonutils.demo.bankoffer.core.enums;

/**
 * @author tjz
 * @date 2022/7/14
 * @description 出盘渠道
 */
public enum BankChannels {
    /**
     * 枚举
     */
    NH("NH"), GS("GS"), YL("YL"), RH("RH");

    private final String name;

    BankChannels (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
