package get_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ByCalendar {
 public static void main(String[] args) {
	 Calendar c = Calendar.getInstance();
	 int year = c.get(Calendar.YEAR);
	 //�·��Ǵ�0��ʼ�ģ���1����
	 int month = c.get(Calendar.MONTH)+1;
	 int day = c.get(Calendar.DAY_OF_MONTH);
	 int hour = c.get(Calendar.HOUR_OF_DAY);
	 int minute = c.get(Calendar.MINUTE);
	 int second = c.get(Calendar.SECOND);
	 
	 System.out.println(year+"-"+month+"-"+day+"  "+hour+":"+minute+":"+second);
	 
	 //CalendarҲ�жԸ�ʽ�����֧�֣�
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
	 Date date=c.getTime();
	 System.out.println("���ڵ�ʱ���ǣ�" + sdf.format(date));
	 
}
}
