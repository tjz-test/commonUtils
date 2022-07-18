package com.inspur.gs.commonutils.demo.design.Filters.impl;

import com.inspur.gs.commonutils.demo.design.Filters.Criteria;
import com.inspur.gs.commonutils.demo.design.Filters.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
