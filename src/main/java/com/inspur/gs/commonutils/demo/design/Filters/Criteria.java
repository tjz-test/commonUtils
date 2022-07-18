package com.inspur.gs.commonutils.demo.design.Filters;

import java.util.List;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
