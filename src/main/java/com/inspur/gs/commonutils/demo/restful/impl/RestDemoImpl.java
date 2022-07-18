package com.inspur.gs.commonutils.demo.restful.impl;

import com.inspur.gs.commonutils.demo.restful.RestDemoInterface;
import java.util.Date;
import java.util.List;

public class RestDemoImpl implements RestDemoInterface {
    @Override
    public String createNewOrder(String order) {
        return null;
    }

    @Override
    public String updateOrderSate(String state) {
        return null;
    }

    @Override
    public String findOrderById(String id) {
        return null;
    }

    @Override
    public List<String> findOrderByCreationDate(Date begin, Date end, Integer page, Integer limit) {
        return null;
    }

    @Override
    public void removeById(String id) {

    }
}
