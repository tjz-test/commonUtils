package com.inspur.gs.commonutils.lcputil;

import com.inspur.edp.cef.entity.condition.EntityFilter;
import com.inspur.edp.cef.entity.condition.FilterCondition;
import com.inspur.edp.cef.entity.condition.SortCondition;
import java.util.ArrayList;

/**
 * @author 14791
 */
public class EntityFilterBuilder {
    private final ArrayList<FilterCondition> condList = new ArrayList<>();

    private final ArrayList<SortCondition> sortList = new ArrayList<>();

    public EntityFilterBuilder addFilter(FilterCondition cond) {
        this.condList.add(cond);
        return this;
    }

    public EntityFilterBuilder addSort(SortCondition sort) {
        this.sortList.add(sort);
        return this;
    }

    public EntityFilter build() {
        EntityFilter entityFilter = new EntityFilter();
        entityFilter.addFilterConditions(this.condList);
        entityFilter.addSortConditions(this.sortList);
        return entityFilter;
    }
}
