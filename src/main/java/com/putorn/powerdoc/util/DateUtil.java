package com.putorn.powerdoc.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    /**
     * 获取YYYY格式
     *
     * @return
     */
    public static String getYear() {
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDate() {
        SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
        return sdfDay.format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getNowDate() {
        SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
        return sdfDays.format(new Date());
    }

    public static String getDate3(Date in_date) {
        SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
        return sdfDays.format(in_date);
    }



    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getDateTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfTime.format(new Date());
    }

    /**
     * 获取时间戳
     * @return
     */
    public static Timestamp getDateTimestamp() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Timestamp.valueOf(sdfTime.format(new Date()));
    }

    /**
     * 获取yyyyMMddHHmmss格式
     *
     * @return
     */
    public static String getDateTime2() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMddHHmmss");
        return (sdfTime.format(new Date()));
    }

    public static String getFormateDate(String strDate) {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            SimpleDateFormat sdfTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdfTime2.format(sdfTime.parse(strDate));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getFormateDate2(String strDate) {
    	SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    	try {
    		SimpleDateFormat sdfTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		return sdfTime2.format(sdfTime.parse(strDate));
    	}catch (ParseException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    /**
     * 获取十七位时间戳
     *
     * @return
     * @throws Exception
     */
    public static String getDateRandomCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }


    /**
     * 获取13位时间戳
     *
     * @return
     */
    public static String getTimeStamp13() {
        Date date = new Date();
        long timestamp = date.getTime();
        return String.valueOf(timestamp);
    }

    /**
     * 获取HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        return sdfTime.format(new Date());
    }

    /**
     * 获取HHmmss格式
     *
     * @return
     */
    public static String getTime2() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("HHmmss");
        return sdfTime.format(new Date());
    }

    /**
     * 日期比较，如果s>=e 返回true 否则返回false
     *
     * @param s
     * @param e
     * @return
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 日期比较，s>e返回1 s=e返回0 s<e返回-1
     *
     * @param s
     * @param e
     * @return
     */
    public static int compareDate2(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return -2;
        }

        long time = fomatDate(s).getTime();
        long time2 = fomatDate(e).getTime();
        if(time > time2){
            return 1;
        }else if(time == time2){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static String  fomatDateForLong(long date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = new Date(date * 1000);
            return fmt.format(dt);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date formatData17(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        try {
            return sdf.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期yyMMdd
     *
     * @return
     */
    public static String fomatDate2(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        try {
            Date parse = fmt.parse(date);
            return fmt.format(parse);
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        }catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }
    
    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDate2(String s) {
    	DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
    	try{
    		fmt.parse(s);
    		return true;
    	}catch (Exception e) {
    		// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
    		return false;
    	}
    }

    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long aa = 0;
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        }catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * 时间相减得到天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

        try{
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        // System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之后的日期
     * daysInt:负数代表往前，正数代表往后
     * @param daysInt
     * @return
     */
    public static String getAfterDayDate2(int daysInt) {
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }
    /**
     * 得到n天之后是周几
     *
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 得到距离该日期month个月，days天后的时间
     * @param startDate
     * @param month
     * @param days
     * @return
     */
    public static Date monthAndDaysAgo(Date startDate,int month,int days) {
        Date result_date ;
        if(startDate == null) {
            result_date =null;
        }else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(calendar.MONTH,month);
            calendar.add(calendar.DAY_OF_MONTH,days);
            result_date = calendar.getTime();
        }

        return result_date;
    }

    /**
     * 字符串转date
     *
     * @param d
     * @return
     */
    public static Date strToDate(String d) {
        int findex = 0;
        int sindex = 0;
        findex = d.indexOf('-', 0);
        sindex = d.indexOf('-', findex + 1);
        if (findex <= 0) {
            findex = d.indexOf('/', 0);
            sindex = d.indexOf('/', findex + 1);
        }if (findex <= 0) {
            return null;
        }
        int l_year = Integer.parseInt(d.substring(0, findex));
        int l_month = Integer.parseInt(d.substring(findex + 1, sindex)) - 1;
        int l_day = Integer.parseInt(d.substring(sindex + 1, d.length()));
        Calendar dt = new GregorianCalendar();
        dt.set(l_year, l_month, l_day);
        return dt.getTime();
    }

    /**
     * 字符串转化日期
     *
     * @param d
     * @return
     */
    public static Calendar strToCalendar(String d) {
        int findex = 0;
        int sindex = 0;
        findex = d.indexOf('-', 0);
        sindex = d.indexOf('-', findex + 1);
        if (findex <= 0) {
            findex = d.indexOf('/', 0);
            sindex = d.indexOf('/', findex + 1);
        }if (findex <= 0) {
            return null;
        }
        int l_year = Integer.parseInt(d.substring(0, findex));
        int l_month = Integer.parseInt(d.substring(findex + 1, sindex)) - 1;
        int l_day = Integer.parseInt(d.substring(sindex + 1, d.length()));
        Calendar dt = new GregorianCalendar();
        dt.set(l_year, l_month, l_day);
        return dt;
    }

    /**
     * 日期转字符串 yyyy-mm-dd
     *
     * @param c
     * @return
     */
    public static String getDateString(Calendar c) {
        String dstr = "";
        String sYear = "";
        String sMonth = "";
        String sDay = "";
        int cYear = c.get(Calendar.YEAR);// 获取当前系统平台下默认日期的“年”。
        int cMonth = c.get(Calendar.MONTH) + 1;// 获取当前系统平台下默认日期的“月”。
        int cDay = c.get(Calendar.DAY_OF_MONTH);
        if (cMonth < 10) {
            sMonth = "0" + cMonth;
        }else {
            sMonth = "" + cMonth;
        }if (cDay < 10) {
            sDay = "0" + cDay;
        }else {
            sDay = "" + cDay;
        }
        sYear = "" + cYear;
        dstr = sYear + "-" + sMonth + "-" + sDay;
        return dstr;
    }

    public static String getMinutes() {
        String result = getDateTime2();
        return result.substring(0,result.length()-2);
    }


	/**
	 * 得到uuid 随机数+生成的hashcode 码
	 * @return
	 */
	public static String getRandomHashCode() {
	    int first = new Random(10).nextInt(8) + 1;
	    int hashCode = UUID.randomUUID().toString().hashCode();
	    if(hashCode < 0) {
	    	hashCode = -hashCode;
	    }
	    return first + String.format("%010d", hashCode);
    }

    /**
     * 把yyyymmdd转成yyyy-MM-dd格式(返回Date格式)
     * @param str
     * @return
     */

    public static Date formatDateStyle(String str){
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sf2 =new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sf2.parse(sf2.format(sf1.parse(str)));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 从身份证获取出生日期
     * @param card
     * @return
     */
    public static String getBirthdayFromCard(String card) {
        StringBuilder birthday = new StringBuilder("");
        //判断身份证长度,15位身份证规则与18位不同
        if(card != null &&  !"".equals(card)) {

            if(card.length() == 15 || card.length() == 18) {
                String unfinish = card.length() == 15 ? "19"+card.substring(6,12) : card.substring(6,14);
                birthday.append(unfinish.substring(0,4)+"-").append(unfinish.substring(4,6)+"-").append(unfinish.substring(6,8));
            }
        }
        return birthday.toString();
    }


    /**
     * 获取当前月的天数
     */

    public static int getDayOfMonth(){
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int day=aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }

    /**
     * 获取当前时间上个月的天数
     */

    public static int getBeforeDayOfMonth(){
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.add(aCalendar.MONTH,-1);
        int day=aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }

    /**
     * 得到上一月的月份(可能跨年)
     * @return
     */
    public static String getBeforeMonth() {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.add(aCalendar.MONTH,-1);

        int cYear = aCalendar.get(Calendar.YEAR);// 获取当前系统平台下默认日期的“年”。
        int cMonth = aCalendar.get(Calendar.MONTH) + 1;// 获取当前系统平台下默认日期的“月”。 月份从0-11

        return cYear+"-"+cMonth;
    }

    /**
     * @Title: 获取当天最后一秒
     * @Description: Get the cache expire time.
     * @return
     */
    public static Date getTodayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

}
