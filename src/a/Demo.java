package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

class Foo {
	Foo(){
		System.out.println("Foo");
	}
	
     void method(Object o){
		System.out.println("method1");
	}
    
    void method(String s){
    	System.out.println("method2");
    }
	
}

public abstract class Demo extends Foo {
	public static void main(String[] args) {
		//Demo demo = new Foo();//非法引用。不能向上引用。
		int x=4;
		System.out.println((x>4)?99.9:9);
		Foo foo = new Foo();
		Foo foo1 = new Foo();
		foo.method(foo1);
	}
	
    static void method3(){
		System.out.println("method3");
	}
	
	void method4(){
		System.out.println("method4");
		method3();
	}

}


