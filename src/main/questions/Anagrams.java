package main.questions;

import java.util.Arrays;
import java.util.Scanner;


public class Anagrams {

	public static void main(String[] args) {
		System.out.println("Enter test cases");
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		String s1 = "", s2 = "";
		boolean result = false;
		
		
		
		
		while (noOfTestCases > 0) {
			
			s1 = sc.next();
			s2 = sc.next();

			result = isAnagram(s1, s2);
			//result = isAnagram2(s1, s2);
			noOfTestCases--;

			if (result)
				System.out.println("YES");
			else {
				System.out.println("NO");
			}
		}
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] s1Chars = s1.toCharArray();
		for (char c : s1Chars) {
			int tempIndex = s2.indexOf(c);
			if (tempIndex != -1) {
				s2 = (s2.substring(0, tempIndex)).concat(s2.substring(
						tempIndex + 1, s2.length()));
			} else {
				return false;
			}
		}
		return true;
	}
}
