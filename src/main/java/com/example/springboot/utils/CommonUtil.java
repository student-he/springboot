package com.example.springboot.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class CommonUtil {

    public final static String SPLIT_STRING = "(中国标准时间)";
    public static final String DATE_TIME_24H_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String[] REPLACE_STRING = new String[]{"GMT+0800", "GMT+08:00"};


    public static boolean isNull(Object[] objs) {
        return objs == null || objs.length == 0;
    }

    public static boolean isNull(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNull(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static boolean isNull(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static boolean isNotNull(Collection<?> collection) {
        return !isNull(collection);
    }

    public static boolean isNotNull(Map<?, ?> map) {
        return !isNull(map);
    }

    public static boolean isNotNull(Object[] objs) {
        return !isNull(objs);
    }

    //字符串判空，空返回“”，非空名和返回字符串
    public static String nvlStr(String str) {
        return str == null ? "" : str;
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 左补0
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String lpadZero(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    /**
     * add by songtk
     * 字符串左补自定义补位符
     *
     * @param inStr
     * @param length
     * @param length
     * @return
     */
    public static String lpad(String inStr, int length, String pad) {
        String outStr = inStr;
        for (int i = inStr.getBytes().length; i < length; i++) {
            outStr = pad + outStr;
        }
        return outStr;
    }


    /*** 把Blob类型转换为byte数组类型
     * @param blob
     * @return
     * */
    public static byte[] blobToBytes(Blob blob) {
        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(blob.getBinaryStream());
            byte[] bytes = new byte[(int) blob.length()];
            int len = bytes.length;
            int offset = 0;
            int read = 0;
            while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
                offset += read;
            }
            return bytes;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                LogUtil.error(e);
            }
        }
    }

    public static Date str2Date(String dateString) {
        try {
            dateString = dateString.split(Pattern.quote(SPLIT_STRING))[0].replace(REPLACE_STRING[0], REPLACE_STRING[1]);
            SimpleDateFormat sf1 = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z", Locale.US);
            Date date = sf1.parse(dateString);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("时间转化格式错误" + "[dateString=" + dateString + "]" + "[DATE_TIME_24H_FORMAT=" + DATE_TIME_24H_FORMAT + "]");
        }
    }

    /**
     * 将Date型日期转换成字符串型日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            if (date != null && !"".equals(date)) {
                dateStr = sdf.format(date);
            }
        } catch (Exception e) {
            dateStr = "";
        }
        return dateStr;
    }

    /**
     * list转Sting
     *
     * @param list
     * @param separator
     * @return
     */
    public static String listToString(List list, char separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i)).append(separator);
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }

    /**
     * 得到当前日期(yyyymmdd)
     *
     * @author Administrator
     */
    public static String getCurrdate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }

    /**
     * 得到当前日期,格式自定义 如：yyyy-MM-dd HH:mm:ss、yyyyMMddHHmmss、yyyy-MM-dd、yyyyMMdd
     *
     * @author Administrator
     */
    public static String getCurrdate(String formatStr) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(calendar.getTime());
    }

}
