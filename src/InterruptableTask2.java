import java.util.concurrent.locks.ReentrantLock;

public class InterruptableTask2 implements Runnable{
	
	static ReentrantLock aLock;
	
	public InterruptableTask2(){
		aLock = new ReentrantLock();
	}
	
	public void run(){
		
		while(true){
			aLock.lock();
			if(Thread.interrupted() )break;
			System.out.println(1);
		}
		System.out.println(4);
		aLock.unlock();
	}
	
	public static void main(String[] args){
		Thread t = new Thread(new InterruptableTask2());
		t.start();
		try
		{
			Thread.sleep(1000);
			t.interrupt();
		} catch (InterruptedException e){}
	}
}
