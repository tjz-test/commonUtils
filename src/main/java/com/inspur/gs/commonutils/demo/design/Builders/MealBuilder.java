package com.inspur.gs.commonutils.demo.design.Builders;

import com.inspur.gs.commonutils.demo.design.Builders.impl.ChickenBurger;
import com.inspur.gs.commonutils.demo.design.Builders.impl.Coke;
import com.inspur.gs.commonutils.demo.design.Builders.impl.Pepsi;
import com.inspur.gs.commonutils.demo.design.Builders.impl.VegBurger;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}