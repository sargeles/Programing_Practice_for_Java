package characteristic;

public class About_Override {
	public void f(){
		System.out.println("About_Override");
	}
	
	public static void main(String[] args) {
		About_Override ab=new About_Override_Child();
		ab.f();
	}

}

class About_Override_Child extends About_Override{
	public void f(){
		System.out.println("About_Override_Child");
	}
}
