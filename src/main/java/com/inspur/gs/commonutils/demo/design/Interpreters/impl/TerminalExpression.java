package com.inspur.gs.commonutils.demo.design.Interpreters.impl;

import com.inspur.gs.commonutils.demo.design.Interpreters.Expression;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}