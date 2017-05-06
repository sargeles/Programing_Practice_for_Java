package trycatchfinally;

public class TryFinally {
	public static void main(String[] args) {
		System.out.println(run());
	}
	
	public static int run(){
		int i=1;
		try{
			System.out.print(i);
			return ++i;
		}finally{
			System.out.print(++i);
		}
	}
	
}
