package main.questions;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class MaxDist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat nf= new DecimalFormat("#.###");
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		double arr[]=new double[n];
		for(int i =0;i<n;i++){
			arr[i]=sc.nextDouble();
		}
		double min=0;
		for(int i =0;i<n;i++){
			double val = sc.nextInt() / arr[i];
			if( min > val )
				min = val;
		}
		double availFuel=sc.nextInt();
		System.out.println(roundDown3(availFuel/min));

	}
	public static double roundDown3(double d) {
	    return (long) (d * 1e5) / 1e3;
	}
	
}
