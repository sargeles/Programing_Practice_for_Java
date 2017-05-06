package characteristic;

public class TypeConversion {
	public static void main(String[] args) {
		
		byte b = 66;
		char c='c';
		//char c = b;//char是无符号的，所以不能转成有符号的
		short s = b;
		
		int i=c;
		long l=i;
		//浮点数在内存中的二进制值不是直接转换为十进制数值的，而是按照公式计算而来，通过公式，虽然只用到了4个字节，但是浮点数却比长整型的最大值要大
		float f=l;
		double d=l;
		
		
	    i=c;
	    System.out.println("output:"+i);

		 i = 99;
		 b = (byte) i;
		 c = (char) i;
		 f = i;
		 
		 System.out.println(String.valueOf(l));
	}

}
