package com.piza.util;

import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VelocityUtils {

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdfShort=new SimpleDateFormat("yyyy-MM-dd");
	public static String format(Date date){
		return sdf.format(date);
	}
	
	public static String formatByLong(Long timestamp){
		return timestamp==null? "":sdf.format(new Date(timestamp*1000));
	}
	
	public static String getToday(){
		return sdfShort.format(new Date());
	}
	
	public static String formatTime(Date date){
		if(date == null){
			return "";
		}
		return sdf.format(date);
	}

    /**
     * 查找一个字符串是否在一个字符串数组中出现
     */
    public static boolean findKeywordExistInArray(String[] target, String keyword) {
        if(null == target) return  false;
        if(null == keyword) return  false;
        for (String str : target) {
            if (str.contains(keyword)) {
                return  true;
            }
        }
        return false;
    }
	
	public static String formatDate(Date date){
		if(date == null){
			return "";
		}
		return sdfShort.format(date);
	}
	
	public static Date parseDate(String s) {
		if (StringUtils.isBlank(s)) {
			return null;
		}
		try {
			return sdfShort.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String dateTimeToString(Date date) {
		if (null == date) {
			return null;
		}
		return sdf.format(date);
	}
	
	public static String dateToString(Date date) {
		if (null == date) {
			return null;
		}
		return sdfShort.format(date);
	}

    /**
     *  根据生日计算出当前年龄
     * @param birthday  生日
     * @return  年龄
     */
    public static Integer getAge(Date birthday) {
        if(null == birthday){
            return null;
        }
       int birthday_ = Integer.valueOf(new SimpleDateFormat("YYYY").format(birthday));
       int now = Calendar.getInstance().get(Calendar.YEAR);
        int age = now - birthday_;
        if(0 >= age) {
            return 1;
        }
        return  age;
    }






	public static String calcTimeDown(Date date){
		if(date == null){
			return "0天0小时";
		}
		Date now=new Date();
		Long day=0l,hours=0l;
		long diff=date.getTime()-now.getTime();
		if(diff<0){
			return "已停止";
		}
		day=diff/(24*60*60*1000);
		hours=(diff%(24*60*60*1000))/(60*60*1000);
		return day+"天"+hours+"小时";
	}
	
	public String formatMoney(Integer fen) {
		if (fen == null) {
			return "";
		} else {
			NumberFormat moneyf = NumberFormat.getCurrencyInstance(Locale.CHINA);
			return moneyf.format(fen.doubleValue() / 100);
		}
	}

    public String formatMoney(Long fen) {
        if (fen == null) {
            return "";
        } else {
            NumberFormat moneyf = NumberFormat.getCurrencyInstance(Locale.CHINA);
            return moneyf.format(fen.doubleValue() / 100);
        }
    }
	
	public String formatMoney(Double d) {
		if (d == null) {
			return "";
		} else {
			NumberFormat moneyf = NumberFormat.getCurrencyInstance(Locale.CHINA);
			return moneyf.format(d);
		}
	}
	
	public String stringShort(String s){
		return (s!=null && s.length()>20) ? s.substring(0,20):s;
	}
	
	public String partMoney(Integer price){
		if(price == null){
			return "￥*****";
		}
		String money=this.formatMoney(price);
		if(money!=null && money.length()>3){
			money=money.substring(0,3);
			money+="*****";
		}else{
			money+="*****";
		}
		
		return money;
	}
	
	public String partMobile(String mobile){
		if(mobile == null){
			return "";
		}
		if(mobile.length()>3){
			mobile=mobile.substring(0,3);
			mobile+="*****";
		}else{
			mobile+="*****";
		}
		return mobile;
	}
	
	
	public String getEmailDomain(String email){
		if(email==null || email.indexOf("@")<0){
			return "";
		}else{
			String[] sp=email.split("@");
			return sp.length==2?sp[1]:"";
		}
	}
	
	public boolean checkDealDate(Date date){
		if(date==null){
			return true;
		}
		Date today=new Date();
		return date.getTime()-today.getTime()>0;
	}

    public String getConfigProperty(String key){
        return SpringUtil.getConfigProperty(key);
    }

//	public static void main(String[] args) {
//		
//		System.out.println(formatMoney(10000));
//	}
	
}
