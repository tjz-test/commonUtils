package com.inspur.gs.commonutils.demo.lambda;

import clover.org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tianjinzan01
 * @date 2022/6/29
 * @describe
 */
public class LambdaTestDemo {
    public static void main(String[] args) {
        List<UserTestEntity> list = new ArrayList<>();
        UserTestEntity userTestEntity1 = new UserTestEntity("1", "01", "202201", "202201");
        UserTestEntity userTestEntity2 = new UserTestEntity("2", "02", "202202", "202202");
        UserTestEntity userTestEntity3 = new UserTestEntity("3", "03", "202203", "202203");
        UserTestEntity userTestEntity4 = new UserTestEntity("4", "04", "202204", "202204");
        UserTestEntity userTestEntity5 = new UserTestEntity("5", "05", "202205", "202205");

        list.add(userTestEntity4);
        list.add(userTestEntity2);
        list.add(userTestEntity1);
        list.add(userTestEntity3);
        list.add(userTestEntity5);
        list.add(userTestEntity5);

        //排序
        List<UserTestEntity> list1 = listOrder(list);

        //去重
        List<UserTestEntity> list3 = listDistinct1(list);

        //去重
        List<UserTestEntity> list4 = listDistinct(list);

        //过滤
        List<UserTestEntity> list5 = listFilter(list);

        //new
        List<String> list6 = listNew(list);

        //最大
        String max = listMax(list);

        //最小
        String min = listMin(list);

        //分组
        Map<String, List<UserTestEntity>> map = listGroup(list);

        //listTomap
        Map<String, UserTestEntity> map1 = listToMap(list);

    }

    /**
     * 排序
     * @param list
     * @return
     */
    private static List<UserTestEntity> listOrder(@NotNull List<UserTestEntity> list) {
        return list.stream().sorted(Comparator.comparing(UserTestEntity::getPeriod, Comparator.naturalOrder())
                .thenComparing(UserTestEntity::getWmonth, Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    /**
     * 分组
     * @param list
     * @return
     */
    private static Map<String, List<UserTestEntity>> listGroup(@NotNull List<UserTestEntity> list) {
        return list.stream().collect(Collectors.groupingBy(UserTestEntity :: getUsercode));
    }

    /**
     * list转map
     * @param list
     * @return
     */
    private static Map<String, UserTestEntity> listToMap(@NotNull List<UserTestEntity> list) {
        return list.stream().collect(Collectors.toMap(UserTestEntity :: getUsercode, a -> a, (k1,k2) -> k1));
    }

    /**
     * 去重
     * @param list
     * @return
     */
    private static List<UserTestEntity> listDistinct(@NotNull List<UserTestEntity> list) {
        return list.stream().filter(p -> StringUtils.isNoneBlank(p.getUsercode()))
                .collect(Collectors.collectingAndThen(Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(UserTestEntity::getUsercode))
                        ), ArrayList :: new));
    }

    private static List<UserTestEntity> listDistinct1(@NotNull List<UserTestEntity> list) {
        return  list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 过滤
     * @param list
     * @return
     */
    private static List<UserTestEntity> listFilter(@NotNull List<UserTestEntity> list) {
        return list.stream().filter(p -> p.getPeriod() == "202201").collect(Collectors.toList());
    }

    /**
     * 截取list
     * @param list
     * @return
     */
    @NotNull
    private static List<UserTestEntity> listSub(List<UserTestEntity> list) {
        return list.subList(0,2);
    }

    /**
     * new list
     * @param list
     * @return
     */
    private static List<String> listNew(@NotNull List<UserTestEntity> list) {
        return list.stream().map(p -> p.getUserarid()).collect(Collectors.toList());
    }

    /**
     * 取最大值
     * @param list
     * @return
     */
    @NotNull
    private static String listMax(@NotNull List<UserTestEntity> list) {
        return list.stream().map(UserTestEntity::getPeriod).max(String :: compareTo).get();
    }

    /**
     * 取最小值
     * @param list
     * @return
     */
    @NotNull
    private static String listMin(@NotNull List<UserTestEntity> list) {
        return list.stream().map(UserTestEntity::getPeriod).min(String :: compareTo).get();
    }

}
