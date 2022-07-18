package com.inspur.gs.commonutils.demo.optional;

import java.util.Optional;

/**
 * Optional不能序列化，不能作为类的字段(field)
 * Optional不能作为方法参数
 *
 * 推荐Optional作为函数返回值
 * Optional和steam组合更有益处
 * eg:String isocode = user.getAddress().getCountry().getIsocode().toUpperCase();
 * 传统用法
 * if (user != null) {
 *     Address address = user.getAddress();
 *     if (address != null) {
 *         Country country = address.getCountry();
 *         if (country != null) {
 *             String isocode = country.getIsocode();
 *             if (isocode != null) {
 *                 isocode = isocode.toUpperCase();
 *             }
 *         }
 *     }
 * }
 * Optional用法
 * String result = Optional.ofNullable(user)
 *   .flatMap(User::getAddress)
 *   .flatMap(Address::getCountry)
 *   .map(Country::getIsocode)
 *   .orElse("default");
 *
 * 总结
 * Optional类对我们最有帮助的一个用例是同Stream或者其他方法组合使用，这些方法会返回一个可构建流畅API的Optional值。
 *
 */
public class OptionalUtils {
    /**
     * 判断输入的字符串是否为空
     * @param str String
     * @return
     */
    public static boolean isEmpty(String str){
        return Optional.ofNullable(str).isPresent();
    }

    /**
     * 判断输入的Integer是否为空
     * @param num Integer
     * @return
     */
    public static boolean isEmpty(Integer num){
        return Optional.ofNullable(num).isPresent();
    }

    /**
     * 判断输入的Double是否为空
     * @param dnum Double
     * @return
     */
    public static boolean isEmpty(Double dnum){
        return Optional.ofNullable(dnum).isPresent();
    }

    /**
     * 判断输入的Object是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        return Optional.ofNullable(obj).isPresent();
    }

    /**
     * 判断输入的List是否为空,获取该对象
     * @param obj
     * @return
     */
    public static Object get(Object obj){
        return Optional.ofNullable(obj).isPresent() ? Optional.ofNullable(obj).get() : null;
    }

    /*orElse()方法内部其实是可以传方法的，与orElseGet()方法不同的是
    如果前面的Optional容器存了个null，那么orElseGet()和orElse()都会调用传入的方法
    但是如果Optional容器中不为null，只有orElse()仍然会调用传入的方法，orElseGet()则不会
    orElseThrow()如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常*/



}
