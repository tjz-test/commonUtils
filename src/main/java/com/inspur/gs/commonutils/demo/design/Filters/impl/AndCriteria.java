package com.inspur.gs.commonutils.demo.design.Filters.impl;

import com.inspur.gs.commonutils.demo.design.Filters.Criteria;
import com.inspur.gs.commonutils.demo.design.Filters.Person;

import java.util.List;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
