package com.inspur.gs.commonutils.stringutil;

import com.inspur.edp.cef.designtime.api.util.Guid;
import io.iec.edp.caf.boot.context.CAFContext;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * StringUtils
 * @author tianjinzan01
 */
public final class StringUtils {

    /**
     * 判空
     * @param string str
     * @return result
     */
    public static boolean IsNullOrEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    /**
     * 判空
     * @param string str
     * @return result
     */
    public static boolean isNullOrEmpty(Object string) {
        return (string == null || string.toString().isEmpty());
    }

    /**
     * 去空格判空
     * @param string str
     * @return result
     */
    public static boolean IsNullOrWhiteSpace(String string) {
        return (string == null || string.trim().isEmpty());
    }

    /**
     * 去空格判空
     * @param string str
     * @return result
     */
    public static boolean isNullOrWhiteSpace(Object string) {
        return (string == null || string.toString().trim().isEmpty());
    }

    /**
     * 左补齐
     * @param str str
     * @param minLength length
     * @param padChar char
     * @return str
     */
    public static String PadLeft(String str, int minLength, char padChar) {
        return padStart(str, minLength, padChar);
    }

    /**
     * 左补齐
     * @param value str
     * @param minLength length
     * @param padChar char
     * @return str
     */
    public static String PadLeft(int value, int minLength, char padChar) {
        String str = String.valueOf(value);
        return padStart(str, minLength, padChar);
    }

    /**
     * 判空
     * @param str str
     */
    private static void checkNotNull(String str) {
        if (str == null) {
            throw new RuntimeException("传入参数为null!");
        }
    }

    /**
     * 补齐处理
     */
    public static String padStart(String string, int minLength, char padChar) {
        checkNotNull(string);
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb = new StringBuilder(minLength);
        for (int i = string.length(); i < minLength; i++) {
            sb.append(padChar);
        }
        sb.append(string);
        return sb.toString();
    }

    /**
     * 截取
     * @param src str
     * @param startIndex start
     * @param length len
     * @return str
     */
    public static String subString(String src, int startIndex, int length) {
        return src.substring(startIndex, startIndex + length);
    }

    /**
     * 右补齐
     * @param string str
     * @param minLength len
     * @param padChar char
     * @return str
     */
    public static String padEnd(String string, int minLength, char padChar) {
        checkNotNull(string);
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb = new StringBuilder(minLength);
        sb.append(string);
        for (int i = string.length(); i < minLength; i++) {
            sb.append(padChar);
        }
        return sb.toString();
    }

    /**
     * 拆分数组
     * @param src str
     * @param separatorChar separt
     * @return str[]
     */
    public static String[] split(String src, char separatorChar) {
        return StringUtils.split(src, separatorChar);
    }

    /**
     * 去除string中str
     * @param srcStr sourcestr
     * @param removeStr removestr
     * @return newstr
     */
    public static String trimEnd(String srcStr, String removeStr) {
        if (IsNullOrWhiteSpace(srcStr)) {
            throw new RuntimeException("srcStr is null or empty or white");
        }
        if (IsNullOrEmpty(removeStr)) {
            throw new RuntimeException("removeStr is null or empty");
        }
        srcStr = srcStr.trim();
        String lastChar;
        while (srcStr.length() > 0) {
            lastChar = subString(srcStr, srcStr.length() - 1, 1);
            if (lastChar.equals(removeStr)) {
                srcStr = subString(srcStr, 0, srcStr.length() - 1);
            }
        }
        return srcStr;
    }

    /**
     * get guid
     * @return str
     */
    public static String getUUID() {
        return Guid.newGuid().toString();
    }

    /**
     * list转string
     * @param list list
     * @param splitor 间隔
     * @return str
     */
    public static String listToStringAddSplitor(List<String> list, String splitor) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder allVal = new StringBuilder();
        for (String val : list) {
            allVal.append(val).append(splitor);
        }
        return trimEnd(allVal.toString(), splitor);
    }

    public static String getNewCode(String code) {
        char[] ch = code.toCharArray();
        int[] array = new int[ch.length];
        StringBuilder newCode = new StringBuilder();
        int i;
        for (i = array.length - 1; i >= 0; i--) {
            array[i] = ch[i];
        }
        for (i = array.length - 1; i >= 0; i--) {
            int num = array[i] + 1;
            if ((48 <= num && num <= 57) || (65 <= num && num <= 90) || (97 <= num && num <= 122)) {
                array[i] = (byte)num;
                break;
            }
            if (array[i] == 57) {
                array[i] = 48;
            } else if (array[i] == 90) {
                array[i] = 65;
            } else if (array[i] == 122) {
                array[i] = 97;
            }
        }
        for (i = 0; i < array.length; i++) {
            int asciicode = array[i];
            newCode.append((char) asciicode);
        }
        return newCode.toString();
    }

    /**
     * obj to string
     */
    public static String convertToString(Object obj) {
        if (obj == null) {
            return "";
        }
        return String.valueOf(obj);
    }

    public static String get8BitDate(OffsetDateTime dateTime) {
        return dateTime.getYear() +
                PadLeft(dateTime.getMonthValue(), 2, '0') +
                PadLeft(dateTime.getDayOfMonth(), 2, '0');
    }

    public static boolean convertToBoolean(Object obj, Boolean defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(obj.toString());
    }

    public static int convertToInt(Object obj) {
        return Integer.parseInt((obj == null) ? "" : obj.toString());
    }

    public static boolean stringIsInt(String str) {
        boolean b;
        int i;
        try {
            i = convertToInt(str);
            b = true;
        } catch (Exception e) {
            return false;
        }
        if (convertToString(i).length() != str.length()) {
            b = false;
        }
        return b;
    }

    public static Date string8ToDate(String string8) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            return sdf.parse(string8);
        } catch (Exception exception) {
            return null;
        }
    }

    public static String dateToString8(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            return sdf.format(date);
        } catch (Exception exception) {
            return "";
        }
    }

    public static String getLocalDateTimeStr(boolean isMillisecond, Boolean isSplitFlag) {
        OffsetDateTime offsetDateTime = CAFContext.current.getCurrentDateTime();
        LocalDateTime time = offsetDateTime.toLocalDateTime();
        String formatStr;
        if (isSplitFlag) {
            formatStr = "yyyy-MM-dd HH:mm:ss";
        } else {
            formatStr = "yyyyMMddHHmmss";
        }
        if (isMillisecond) {
            if (isSplitFlag) {
                formatStr = formatStr + " SSS";
            } else {
                formatStr = formatStr + "SSS";
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        return time.format(formatter);
    }

    public static String removeEscapeAndQuatationForJsonStr(String jsonStr) {
        if (jsonStr.lastIndexOf('\\', 9) > 0) {
            jsonStr = jsonStr.replace("\\", "");
        }
        jsonStr = jsonStr.replace(" ", "");
        jsonStr = jsonStr.replace("\n", "");
        jsonStr = jsonStr.replace("\t", "");
        char[] arr = jsonStr.toCharArray();
        int len = arr.length;
        if (arr[0] == '"') {
            if (arr[len - 1] == '"') {
                jsonStr = new String(arr, 1, len - 2);
            } else {
                jsonStr = new String(arr, 1, len - 1);
            }
        } else if (arr[len - 1] == '"') {
            jsonStr = new String(arr, 0, len - 1);
        } else {
            jsonStr = new String(arr, 0, len);
        }
        return jsonStr;
    }

    public static StringBuilder replaceAll(StringBuilder sb, String oldStr, String newStr) {
        if (IsNullOrEmpty(oldStr) || IsNullOrEmpty(newStr)) {
            return sb;
        }
        int index = sb.indexOf(oldStr);
        if (index > -1 && !oldStr.equals(newStr)) {
            int lastIndex;
            while (index > -1) {
                sb.replace(index, index + oldStr.length(), newStr);
                lastIndex = index + newStr.length();
                index = sb.indexOf(oldStr, lastIndex);
            }
        }
        return sb;
    }

    public static StringBuilder remove(StringBuilder sb, int startIndex, int length) {
        return sb.delete(startIndex, startIndex + length);
    }

    public static String getMapValueByKey(Map<String, Object> map, String key) {
        if (map != null && map.containsKey(key)) {
            return convertToString(map.get(key));
        }
        return "";
    }

    public static String getMapStringValueByKey(Map<String, String> map, String key) {
        if (map != null && map.containsKey(key)) {
            return map.get(key);
        }
        return "";
    }
}


