package main.questions;

public class ReverseString {
	
	public static void main(String[] args) {
		String s ="abcdefgh";
		System.out.println(reverseRecursive(s));
	}
	private static String reverseRecursive(String str){
		//base condition
		if(str.length()<2){
			return str;
		}
		
		//recursive condition
		return reverseRecursive(str.substring(1)) + str.charAt(0);
	}
}
