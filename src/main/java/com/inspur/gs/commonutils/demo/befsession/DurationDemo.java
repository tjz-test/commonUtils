package com.inspur.gs.commonutils.demo.befsession;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Duration类通过秒和纳秒相结合来描述一个时间量，最高精度是纳秒。
 * 时间量可以为正也可以为负，比如1天（86400秒0纳秒）、-1天（-86400秒0纳秒）、1年（31556952秒0纳秒）、1毫秒（0秒1000000纳秒）等。
 * 线程安全
 */
public class DurationDemo {

    public void demo() {

        //基于天、时、分、秒、纳秒创建。
        Duration fromDays = Duration.ofDays(1);
        Duration fromHours = Duration.ofHours(1);
        Duration fromMinutes = Duration.ofMinutes(1);
        Duration fromSeconds = Duration.ofSeconds(1);
        Duration fromMillis = Duration.ofMillis(1);
        Duration fromNanos = Duration.ofNanos(1);

        //通过LocalDateTime或者LocalTime 类，然后使用between获取创建Duration。
        LocalDateTime start = LocalDateTime.of(2022, 1, 1, 8, 0, 0);
        LocalDateTime end = LocalDateTime.of(2022, 1, 2, 8, 30, 30);
        Duration duration = Duration.between(start, end);

        //解析方法
        /*"PT20.345S" -- parses as "20.345 seconds"
        "PT15M"     -- parses as "15 minutes" (where a minute is 60 seconds)
        "PT10H"     -- parses as "10 hours" (where an hour is 3600 seconds)
        "P2D"       -- parses as "2 days" (where a day is 24 hours or 86400 seconds)
        "P2DT3H4M"  -- parses as "2 days, 3 hours and 4 minutes"
        "P-6H3M"    -- parses as "-6 hours and +3 minutes"
        "-P6H3M"    -- parses as "-6 hours and -3 minutes"
        "-P-6H+3M"  -- parses as "+6 hours and -3 minutes"*/
        Duration fromChar1 = Duration.parse("P1DT1H10M10.5S");
        Duration fromChar2 = Duration.parse("PT10M");

        //比较两个时间的差
        Instant start1 = Instant.parse("2017-10-03T10:15:30.00Z");
        Instant end1 = Instant.parse("2017-10-03T10:16:30.00Z");
        // start - end
        Duration duration1 = Duration.between(start1, end1);
        // 任何一个时间单元为负数，则返回true。true：end早于start
        duration1.isNegative();

        //增减
        Duration duration2 = Duration.ofHours(2);
        Duration newDuration = duration2.plusSeconds(33);
        Duration newDuration1 = duration2.plusDays(33);
        Duration newDuration2 = duration2.plusMillis(33);
        Duration newDuration3 = duration2.plusMinutes(33);
        Duration newDuration4 = duration2.plusHours(33);
        Duration newDuration5 = duration2.plusNanos(33);

        //单位转换
        Duration duration3 = Duration.ofHours(2);
        duration3.toDays();     // 0
        duration3.toHours();    // 2
        duration3.toMinutes();  // 120
        duration3.toMillis();   // 7200000
        duration3.toNanos();    // 7200000000000
    }

}
