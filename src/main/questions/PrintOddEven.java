package main.questions;



public class PrintOddEven {
	public static void main(String[] args) {

		Thread odd = new Thread(new PrintThread(10, true), "Odd");
		Thread even = new Thread(new PrintThread(10, false), "Even");
		odd.start();
		even.start();
		
		try {
			odd.join();
			even.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread Execution Complete!");
	}
}

class PrintThread implements Runnable {

	int n;
	static int i=1;
	boolean isOdd;
	static Monitor monitor =new Monitor();

	PrintThread(int n, boolean isOdd) {
		this.n = n;
		this.isOdd = isOdd;
	}

	@Override
	public void run() {
	
		while(i<=n) {
		printNum();
			}
	}

	private void printNum() {
		synchronized (monitor) {
		try {
			print(i++);
			monitor.notify();
			monitor.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

	void print(int i) {
		System.out.println(Thread.currentThread().getName() + " " + i);
	}

static class Monitor{}
}