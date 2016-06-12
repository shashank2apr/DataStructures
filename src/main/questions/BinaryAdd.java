package main.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinaryAdd{
	 public static void main(String[] args) throws IOException {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    String[] num;
		    while ((s = in.readLine()) != null) {
		    	num=s.split("\\s+");
		   //   System.out.println(num[0]+" " +num[1]);
		      System.out.println(sumBinary(num[0],num[1]));
		      
		    }
		  }

	private static String sumBinary(String str1, String str2) {
		String result=null;
		
		if(str1==null || str2 ==null)
			return result;

		int num1 = Integer.parseInt(str1, 2);
		int num2 = Integer.parseInt(str2, 2);

		int sum = num1 + num2;
		result = Integer.toBinaryString(sum);//
		
		result.replaceFirst("^0+(?!$)", "");
		
		return result;
	}
}