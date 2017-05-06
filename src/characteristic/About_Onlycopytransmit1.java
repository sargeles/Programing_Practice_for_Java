package characteristic;

import org.junit.Test;

public class About_Onlycopytransmit1 {
	
	@Test
	public void test1(){
		int i=0;
		String st="null";
		
		changeInt(i);
		changeString(st);
		
		System.out.println(i);
		System.out.println(st);
		
	}
	
    void changeString (String st){
		st= "changed!";
	}
	
    void changeInt (int i){
    	i=1;
    }
	
}
