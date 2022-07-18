package com.inspur.gs.commonutils.lcputil;

import com.inspur.edp.cef.entity.condition.ExpressCompareType;
import com.inspur.edp.cef.entity.condition.ExpressRelationType;
import com.inspur.edp.cef.entity.condition.ExpressValueType;
import com.inspur.edp.cef.entity.condition.FilterCondition;
import com.inspur.gs.commonutils.stringutil.StringUtils;

/**
 * @author 14791
 */
public class FilterBuilder {
    private int lBracket = 0;

    private String filterFiled;

    private ExpressCompareType compareType = ExpressCompareType.forValue(0);

    private String value;

    private int rBracket = 0;

    private ExpressRelationType relationType = ExpressRelationType.forValue(0);

    private ExpressValueType expresstype = ExpressValueType.forValue(0);

    public FilterBuilder setLbracket (int cnt) {
        this.lBracket = cnt;
        return this;
    }

    public FilterBuilder setFiled(String filed) {
        this.filterFiled = filed;
        return this;
    }

    public FilterBuilder setCompare(ExpressCompareType compare) {
        this.compareType = compare;
        return this;
    }

    public FilterBuilder setValue(String val) {
        this.value = val;
        return this;
    }

    public FilterBuilder setRBracket (int cnt) {
        this.rBracket = cnt;
        return this;
    }

    public FilterBuilder setRelation(ExpressRelationType relation) {
        this.relationType = relation;
        return this;
    }

    public FilterBuilder setExpress(ExpressValueType express) {
        this.expresstype = express;
        return this;
    }

    public FilterCondition build() {
        if (StringUtils.IsNullOrEmpty(this.filterFiled)) {
            throw new RuntimeException("条件字段不为空");
        } if (this.value == null) {
            throw new RuntimeException("条件" + this.filterFiled + "不为空");
        }
        return new FilterCondition(this.lBracket, this.filterFiled, this.compareType, this.value, this.rBracket, this.relationType, this.expresstype);
    }
}

