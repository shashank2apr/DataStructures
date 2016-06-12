package main.questions;

public class Fibonacci {
public static void main(String[] args) {
	for(int i=1;i<5;i++)
		System.out.println(printFibonacci(i));
}

private static int printFibonacci(int i) {
	if(i==1||i==2){
		//System.out.println(i);
		return 1;
	}
	//System.out.println(i);
	return printFibonacci(i-1)+printFibonacci(i-2);
	
}
}
