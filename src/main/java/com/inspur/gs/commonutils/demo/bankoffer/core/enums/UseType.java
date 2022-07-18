package com.inspur.gs.commonutils.demo.bankoffer.core.enums;

/**
 * @author tjz
 * @date 2022/7/18
 * @description
 */
public enum UseType {
    /**
     *
     */
    USE("USE"),UNIS("UNIS");

    private final String name;

    UseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
