package a;

public class Demo1 {
	public static void main(String[] args) {
		
		int[] input={2012,12,1};
		boolean b = false;
		int n= 0;
		if(input[0]%100==0){
			if(input[0]%400==0) b=true;
		}else if(input[0]%4==0){
			b=true;
		}
		
		switch(input[1]-1){
		case 12: n+=31;
		case 11: n+=30;
		case 10: n+=31;
		case 9: n+=30;
		case 8: n+=31;
		case 7: n+=31;
		case 6: n+=30;
		case 5: n+=31;
		case 4: n+=30;
		case 3: n+=31;
		case 2: n+=(b?29:28);
		case 1: n+=31;break;
		default:break;
		}
		
		n+=input[2];
		
		System.out.println(n);
		
	}
}
