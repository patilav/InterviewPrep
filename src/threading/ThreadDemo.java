package threading;

class PrintDemo { 
	public void printCount() { 
		try{
			for(int i=5; i>0; i--) {
				System.out.println("Counter "+ i);
			}
		} catch(Exception ex){
			System.out.println("Thread interrupted");
		}
	}
}
class ThreadD extends Thread {
	private Thread t;
	private String threadName;
	PrintDemo PD;
	ThreadD(String name, PrintDemo p){
		this.threadName = name;
		this.PD = p;
	}
	
	public void run() {
		synchronized (PD) {
			PD.printCount();			
		}
		System.out.println("Thread"+ threadName + "  exiting");
	}
	
	public void start() { 
		System.out.println("Starting  "+ threadName);
		if (t==null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

class ThreadDemo{
	public static void main(String args[]){
		PrintDemo pd = new PrintDemo();
		ThreadD t1 = new ThreadD("Thread 1", pd);
		ThreadD t2 = new ThreadD("Thread 2", pd);
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		} catch (Exception ex){
			System.out.println("Interrupted");
		}
	}
}
