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
		
		/** �����ʽ: Mon May 05 15:23:58 CST 2014 */  
        System.out.println(d);  

        /** �Զ����ʽ */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = sdf.format(d);
        System.out.println(s);  
        
        /** �����ʽ: 2014-5-5 */  
        s = DateFormat.getDateInstance().format(d);  
        System.out.println(s);  
   
        /** �����ʽ: 2014-5-5 */  
        s = DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);  
        System.out.println(s);  
   
        /** �����ʽ: 2014��5��5�� ����һ */  
        s = DateFormat.getDateInstance(DateFormat.FULL).format(d);  
        System.out.println(s);  
   
        /** �����ʽ: 2014-5-5 */  
        s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);  
        System.out.println(s);  
   
        /** �����ʽ: 14-5-5 */  
        s = DateFormat.getDateInstance(DateFormat.SHORT).format(d);  
        System.out.println(s);  
   
        /** �����ʽ: 2014-5-05 00:00:00 ��дHΪ24Сʱ�� */  
        DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        s = sdf.format(d);  
        System.out.println(s);  
   
        /** �����ʽ: 2014-5-05 00:00:00 СдhΪ12Сʱ�� */  
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        s = sdf2.format(d); 
        System.out.println(s);  
   
        /** �����ʽ: 20140505000000 */  
        DateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");  
        s = sdf3.format(d);  
        System.out.println(s);  
   
        /** �ַ���ת�������ڸ�ʽ */  
        s = sdf.format(d);  
        Date today = sdf.parse(s);  
        System.out.println("�ַ���ת�����ڣ�" + today);  
   
	}

}
