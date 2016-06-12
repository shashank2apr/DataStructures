package main.questions;

public class PermutationsOfString {
	public static void main(String[] args) {
		char[] str={'a','b','c','d'};
		//permutation("abc");
		permRecur(str,0,str.length-1);
	}

	private static void permRecur(char[] str, int l, int r) {
		//base case
		if(l==r){
			System.out.println(str);
		}
		
		
		//recursive case
		for(int i=l;i<=r;i++){
			swap(str,i,l);
			permRecur(str, l+1, r);
			swap(str,i,l);
		}
		
	}

	private static void swap(char[] str, int i, int l) {
			char temp=str[i];
			str[i]=str[l];
			str[l]=temp;
		
	}

	/* * A method exposed to client to calculate permutation of String in Java. */ 
	public static void permutation(String input)
	{
		permutation("", input); 
		}
	
	/** Recursive method which actually prints all permutations
	 ** of given String, but since we are passing an empty String 
	 ** as current permutation to start with, 
	 ** I have made this method private and didn't exposed it to client. 
	 **/ 
	private static void permutation(String perm, String word) 
	{ 
		if (word.isEmpty())
		{
			System.err.println(perm + word); 
			}
		else {
			for (int i = 0; i < word.length(); i++) {
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); } } } 
}
