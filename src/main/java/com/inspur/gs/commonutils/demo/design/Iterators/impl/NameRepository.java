package com.inspur.gs.commonutils.demo.design.Iterators.impl;

import com.inspur.gs.commonutils.demo.design.Iterators.Container;
import com.inspur.gs.commonutils.demo.design.Iterators.Iterator;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class NameRepository implements Container {
    public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
