package thread;

/** 
* ������չThread��ʵ�ֵĶ��̳߳���
*/ 
public class TestThread extends Thread{ 
    public TestThread(String name) {
        super(name);
    } 

    public void run() {
        for(int i = 0;i<5;i++){
            for(long k= 0; k <10;k++)
            System.out.println(this.getName()+" :"+i);
        } 
    }

    public static void main(String[] args) {
        Thread t1 = new TestThread("����");
        Thread t2 = new TestThread("����");
        t1.start(); 
        t2.start(); 
    } 
}