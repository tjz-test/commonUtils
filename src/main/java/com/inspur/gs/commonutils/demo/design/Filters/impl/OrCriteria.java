package com.inspur.gs.commonutils.demo.design.Filters.impl;

import com.inspur.gs.commonutils.demo.design.Filters.Criteria;
import com.inspur.gs.commonutils.demo.design.Filters.Person;

import java.util.List;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

        for (Person person : otherCriteriaItems) {
            if(!firstCriteriaItems.contains(person)){
                firstCriteriaItems.add(person);
            }
        }
        return firstCriteriaItems;
    }
}