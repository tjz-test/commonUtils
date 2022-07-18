package com.inspur.gs.commonutils.lcputil;

import com.inspur.edp.cef.entity.condition.SortCondition;
import com.inspur.edp.cef.entity.condition.SortType;

/**
 * @author 14791
 */
public class SortBuilder {
    private String sortField;

    private SortType sortType;

    public SortBuilder setField(String field) {
        this.sortField = field;
        return this;
    }

    public SortBuilder setType(SortType type) {
        this.sortType = type;
        return this;
    }

    public SortCondition build() {
        return new SortCondition(this.sortField, this.sortType);
    }
}
