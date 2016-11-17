package concurrent_lock;
import java.util.concurrent.locks.*;
class Display{
	ReentrantLock l = new ReentrantLock();
	public void wish(String name){
		l.lock();
		for(int i=0;i<3;i++){
			System.out.print("Good Morning ");
			try{Thread.sleep(2000);}
			catch(InterruptedException e){
				System.out.println(e);
			}
			System.out.println(name);
		}
		l.unlock();
	}
}
class MyThread extends Thread{
	Display d;
	String name;
	MyThread(Display d,String name){
		this.d = d;
		this.name = name;
	}
	public void run(){
		d.wish(name);
	}
}
public class ReentrantTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d= new Display();
		MyThread t1 =new MyThread(d,"Dhoni");
		MyThread t2 =new MyThread(d,"Yuvraj");
		MyThread t3 =new MyThread(d,"Kohli");
		t1.start();
		t2.start();
		t3.start();
		

	}

}
