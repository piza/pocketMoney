package com.piza.util;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static SimpleDateFormat ymd              = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat y_m_d            = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat m_d              = new SimpleDateFormat("MM/dd");
    public static SimpleDateFormat y_m_d_h_m_s      = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat y_m_d_h_m        = new SimpleDateFormat("yyyyMMddHHmm");
    public static SimpleDateFormat yyyyMMddHHmmssSSS        = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static final int        DAY_SECONDS      = 86399;
    public static final int        DAY_FULL_SECONDS = 86400;

    public static String getymdhmss() {
        return yyyyMMddHHmmssSSS.format(new Date());
    }

    public static Integer getDays(Date start,
                                  Date end) {
        Integer days = 0;
        if (start != null && end != null) {
            Integer seconds = (int) ((end.getTime() - start.getTime()) / 1000);
            days = seconds / DAY_FULL_SECONDS;
        }
        return days;
    }

    public static Integer minute2Index(Date date) {
        DateTime dt = new DateTime(date.getTime());
        return dt.getMinuteOfDay() / 10;
    }

    public static Integer getInt() {
        long time = new Date().getTime();
        return (int) (time / 1000);
    }

    public static String getYmdhm(int day,
                                  int minute) {
        DateTime dt = new DateTime();
        dt = dt.minusMillis(dt.getMillisOfDay());
        dt = dt.plusDays(day);
        dt = dt.plusMinutes(minute);
        return dt.toString("yyyyMMddHHmm");
    }

    public static Date getYmdhmDate(String s) {
        if (s == null) {
            return null;
        }
        try {
            return y_m_d_h_m.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getymdhm(Date d) {
        if (d == null) {
            return null;
        }
        try {
            return y_m_d_h_m.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * @return 返回当前年月日字符串 :20131025
     */
    public static String getYmd() {
        return ymd.format(new Date());
    }

    public static String getYmd(Date d) {
        if (d == null) {
            return null;
        }
        try {
            return ymd.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseYMD(String s) {
        if (s == null) {
            return null;
        }
        try {
            return y_m_d.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getyyyy_MM_dd(Date d) {
        if (d == null) {
            return null;
        }
        try {
            return y_m_d.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMM_dd(Date d) {
        if (d == null) {
            return null;
        }
        try {
            return m_d.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseYMDHMS(String s) {
        if (s == null) {
            return null;
        }
        try {
            return y_m_d_h_m_s.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getyyyy_MM_dd_hms(Date d) {
        if (d == null) {
            return null;
        }
        try {
            return y_m_d_h_m_s.format(d);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getDayStartTime(Date startTime) {
        if (startTime == null) {
            return null;
        }
        DateTime dt = new DateTime(startTime.getTime());
        dt = dt.minusMillis(dt.getMillisOfDay());
        return dt.toDate();
    }

    public static Date getDayEndTime(Date endTime) {
        if (endTime == null) {
            return null;
        }
        DateTime dt = new DateTime(endTime.getTime());
        dt = dt.minusMillis(dt.getMillisOfDay()).plusSeconds(DAY_SECONDS);
        return dt.toDate();
    }

    public static Date getMonthStart(Date time) {
        if (time == null) {
            return null;
        }
        DateTime dt = new DateTime(time.getTime());
        dt = dt.minusMillis(dt.getMillisOfDay()).minusDays(dt.getDayOfMonth() - 1);
        return dt.toDate();
    }

    public static Date getMonthEndTime(Date endTime) {
        if (endTime == null) {
            return null;
        }
        DateTime dt = new DateTime(getMonthStart(new DateTime(endTime.getTime()).plusMonths(1).toDate())).minusDays(1).plusSeconds(DAY_SECONDS);
        return dt.toDate();
    }

    public static Date getQuarterStart(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dt = new DateTime(date.getTime()).minusMonths(1);
        dt = dt.withMonthOfYear(dt.getMonthOfYear() / 3 * 3 + 1);
        return getMonthStart(dt.toDate());
    }

    public static Date getQuarterEnd(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dt = new DateTime(date.getTime()).minusMonths(1);
        dt = dt.withMonthOfYear(dt.getMonthOfYear() / 3 * 3 + 3);
        return getMonthEndTime(dt.toDate());
    }

    public static Date getWeekStart(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dt = new DateTime(date.getTime());
        dt = dt.withDayOfWeek(1);
        return getDayStartTime(dt.toDate());
    }

    public static Date getWeekEnd(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dt = new DateTime(date.getTime());
        dt = dt.withDayOfWeek(1).plusDays(6);
        return getDayEndTime(dt.toDate());
    }
    
    public static Integer getWeekNum(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dt = new DateTime(date.getTime());
        return (dt.getWeekyear()%100) * 100 + dt.getWeekOfWeekyear();
    }


    public static Date addDay(Date srcDate,int days){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(srcDate);
        rightNow.add(Calendar.DAY_OF_YEAR,days);
        return rightNow.getTime();
    }

    public static String getWeekDay(Date srcDate){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(srcDate);
        switch (rightNow.get(Calendar.DAY_OF_WEEK)){
            case 2:return "周一";
            case 3:return "周二";
            case 4:return "周三";
            case 5:return "周四";
            case 6:return "周五";
            case 7:return "周六";
            case 1:return "周日";
        }
        return "";
    }


//    public  static void main(String[] arg){
//        Date today=new Date();
//
//        System.out.println(getWeekDay(addDay(today,5)));
//
//
//    }
}
