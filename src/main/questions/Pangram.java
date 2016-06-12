package main.questions;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
	Set<Character> set= new HashSet<>();
	public boolean isPangram(String string) {
		for(char c='a';c<'z';c++)
			set.add(c);
		string=string.toLowerCase();
		for(int i=0;i<string.length();i++){
			//System.out.print(set);
			//if(' '!=string.charAt(i))
				set.remove(string.charAt(i));
			}
		System.out.println(set);
		return set.isEmpty();
	}
	
	public static void main(String[] args) {
		Pangram p=new Pangram();
		String s="We promptly judged antique ivory buckles for the next prize";
		System.out.println(p.isPangram2(s));
	}

	private boolean isPangram2(String s) {
		Set set=new HashSet<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c>='a' && c<='z')
				set.add(c);				
		}
		System.out.println(set.size());
		return (set.size()==26);
	}

	
}
