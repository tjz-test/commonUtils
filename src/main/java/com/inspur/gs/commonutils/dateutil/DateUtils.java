package com.inspur.gs.commonutils.dateutil;

import com.inspur.gs.commonutils.stringutil.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tianjinzan01
 * @describe 日期处理
 */
public class DateUtils {

    public static String getNextDatePlusDay(String date, int addDay) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.DATE, addDay);
        return getDateStringF8(calendar);
    }

    public static String getNextDatePlusYear(String date, int addYear) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.YEAR, addYear);
        return getDateStringF8(calendar);
    }

    public static int getCompareDate(String startDate, String endDate) {
        Date date1 = StringUtils.string8ToDate(startDate);
        Date date2 = StringUtils.string8ToDate(endDate);
        assert date2 != null;
        assert date1 != null;
        long l = date2.getTime() - date1.getTime() + 1000L;
        long d = l / 86400000L;
        return StringUtils.convertToInt(d);
    }

    public static Calendar getCalendar(String str) {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date date = dateFormat.parse(str);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static String getDateStringF8(Calendar cale) {
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        return year + ((month < 10) ? ("0" + month) : (month + "")) + ((day < 10) ? ("0" + day) : (day + ""));
    }

    public static String getYear(String date) {
        return StringUtils.subString(date, 0, 4);
    }

    public static String getMonthAndDay(String date) {
        return StringUtils.subString(date, 4, 4);
    }

    public static boolean isValidDate(String str) {
        boolean result = true;
        if (!StringUtils.IsNullOrWhiteSpace(str) && str.length() == 8) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            try {
                format.setLenient(false);
                format.parse(str);
            } catch (ParseException e) {
                return false;
            }
        } else {
            result = false;
        }
        return result;
    }

    public static String getNextYear(String year) {
        return StringUtils.convertToString(StringUtils.convertToInt(year) + 1);
    }

    public static String getPreYear(String year) {
        return StringUtils.convertToString(StringUtils.convertToInt(year) - 1);
    }

    public static Map<String, String> getDateWithYear4Normal(Boolean isFirstPeriod, String year, String preZzrq, String qsrq, String zzrq) {
        if (isFirstPeriod && qsrq.compareTo("0701") >= 0) {
            year = getPreYear(year);
        }
        if (!isFirstPeriod && preZzrq.compareTo(qsrq) > 0) {
            year = getNextYear(year);
        }
        String beginDate = year + qsrq;
        if (qsrq.compareTo(zzrq) > 0) {
            year = getNextYear(year);
        }
        String endDate = year + zzrq;
        Map<String, String> map = new HashMap<>(16);
        map.put("year", year);
        map.put("beginDate", beginDate);
        map.put("endDate", endDate);
        return map;
    }

    public static String getDateWithYear4Adjust(String firstMonDay, String lastMonDay, String year, String date) {
        String dateWithYear;
        if (firstMonDay.compareTo(lastMonDay) < 0) {
            dateWithYear = year + date;
        } else if (firstMonDay.compareTo("0701") >= 0) {
            String firstDayYear = getPreYear(year);
            if (date.compareTo(firstMonDay) >= 0) {
                dateWithYear = firstDayYear + date;
            } else {
                dateWithYear = year + date;
            }
        } else {
            String endDayYear = getNextYear(year);
            if (date.compareTo(firstMonDay) >= 0) {
                dateWithYear = year + date;
            } else {
                dateWithYear = endDayYear + date;
            }
        }
        return dateWithYear;
    }

    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        return StringUtils.convertToString(date.get(Calendar.YEAR));
    }
}