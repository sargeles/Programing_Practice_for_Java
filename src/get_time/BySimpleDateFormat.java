package get_time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BySimpleDateFormat {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		String s;
		
		/** 输出格式: Mon May 05 15:23:58 CST 2014 */  
        System.out.println(d);  

        /** 自定义格式 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = sdf.format(d);
        System.out.println(s);  
        
        /** 输出格式: 2014-5-5 */  
        s = DateFormat.getDateInstance().format(d);  
        System.out.println(s);  
   
        /** 输出格式: 2014-5-5 */  
        s = DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);  
        System.out.println(s);  
   
        /** 输出格式: 2014年5月5日 星期一 */  
        s = DateFormat.getDateInstance(DateFormat.FULL).format(d);  
        System.out.println(s);  
   
        /** 输出格式: 2014-5-5 */  
        s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);  
        System.out.println(s);  
   
        /** 输出格式: 14-5-5 */  
        s = DateFormat.getDateInstance(DateFormat.SHORT).format(d);  
        System.out.println(s);  
   
        /** 输出格式: 2014-5-05 00:00:00 大写H为24小时制 */  
        DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        s = sdf.format(d);  
        System.out.println(s);  
   
        /** 输出格式: 2014-5-05 00:00:00 小写h为12小时制 */  
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        s = sdf2.format(d); 
        System.out.println(s);  
   
        /** 输出格式: 20140505000000 */  
        DateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");  
        s = sdf3.format(d);  
        System.out.println(s);  
   
        /** 字符串转换城日期格式 */  
        s = sdf.format(d);  
        Date today = sdf.parse(s);  
        System.out.println("字符串转成日期：" + today);  
   
	}

}
