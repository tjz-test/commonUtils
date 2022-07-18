package com.inspur.gs.commonutils.demo.design.Iterators;

import com.inspur.gs.commonutils.demo.design.Iterators.impl.NameRepository;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
