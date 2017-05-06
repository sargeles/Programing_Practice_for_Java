package characteristic;

class Q {
	int n;
	boolean va=false;

	synchronized int get() {
		if(!va)
		try{
			wait();
		}catch(InterruptedException e){
			System.out.println("InterrupteException caught!");
		}
		System.out.println("Got: " + n);
		va=false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		if(va)
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("InterrupteException caught!");
			}
		this.n = n;
		va=true;
		System.out.println("Put: " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int i = 0;

		while (q.n<100) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {

		while (q.n<100) {
			q.get();
		}
	}
}

class PC {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}
}