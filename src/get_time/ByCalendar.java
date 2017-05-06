package get_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ByCalendar {
 public static void main(String[] args) {
	 Calendar c = Calendar.getInstance();
	 int year = c.get(Calendar.YEAR);
	 //月份是从0开始的，加1修正
	 int month = c.get(Calendar.MONTH)+1;
	 int day = c.get(Calendar.DAY_OF_MONTH);
	 int hour = c.get(Calendar.HOUR_OF_DAY);
	 int minute = c.get(Calendar.MINUTE);
	 int second = c.get(Calendar.SECOND);
	 
	 System.out.println(year+"-"+month+"-"+day+"  "+hour+":"+minute+":"+second);
	 
	 //Calendar也有对格式输出的支持：
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	 Date date=c.getTime();
	 System.out.println("现在的时间是：" + sdf.format(date));
	 
}
}
