package com.inspur.gs.commonutils.demo.bankoffer.core.enums;

/**
 * @author tjz
 * @date 2022/7/14
 * @description
 */
public enum SnapDeals {
    /**
     * 枚举
     */
    GENERATENUM("GENERATENUM"), OUTBOUND("OUTBOUND"), REWIND("REWIND");

    private final String name;

    SnapDeals (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
