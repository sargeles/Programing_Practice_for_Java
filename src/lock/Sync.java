package lock;

import java.util.concurrent.Semaphore;

public class Sync {

	public static void main(String[] args) {
		final Sync run = new Sync();
		final Semaphore done = new Semaphore(0);
		System.out.println("S");
		new Thread(){public void run(){run.x();done.release();}}.start();
		new Thread(){public void run(){run.y();done.release();}}.start();
		new Thread(){public void run(){run.z();done.release();}}.start();
		try{
			done.acquire(3);
		}catch(InterruptedException e){}
		System.out.println("E");
	}
	synchronized public void x() {System.out.println("x");delay();}
	synchronized public void y() {System.out.println("y");delay();}
	public void z() {System.out.println("z");delay();}
	void delay(){
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
	}
	
}
