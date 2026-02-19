class MyThread extends Thread
{
	public void run()
	{
		int count1 = 0;
		for(int i = 0; i<15; i++)
		{
			System.out.println("My thread class " +i);
			count1++;
		}
		System.out.println(count1);
	}
}

class MyThread1 extends Thread
{
	public synchronized void run()
	{
		int count = 0;
		for(int i = 0; i<20; i++)
		{
			System.out.println("My thread1 class " +i);
			count++;
		}
		System.out.println(count);
	}
}

public class Demo 
{
	public static void main(String args[])
	{
		MyThread t = new MyThread();
		MyThread1 t1 = new MyThread1();
		t.start();
		t1.start();
		
		System.out.println();
		for(int i = 0; i<20; i++)
		{
			System.out.println("Main class " +i);
			
		}
	}
}
