package main.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                 "icecream","and","go","i","like","ice","cream"};
		 List<String> dictList = new ArrayList<>();
		 dictList = Arrays.asList(dictionary);
		
		 String input = "imobilesamsungmanicecreamandandgo";
		 if(wordBreak(dictList,input))
			 System.out.println("TRUE");
		 else
			 System.out.println("FALSE");
		 
		System.out.println(dictList.contains("imobile"));

	}

	private static boolean wordBreak(List<String> dictionary, String input) {
		
		//base case
		if(input.length()==0){
			return true;
		}
		for(int i=1;i<=input.length();i++){
			//System.out.println("input.substring(0,i) =  "+input.substring(0,i));
			//System.out.println("input.substring(i)  ="+input.substring(i));
			if(dictionary.contains(input.substring(0,i)) && wordBreak(dictionary, input.substring(i))){
				return true;
			}
		}		
		return false;
	}

	
	 
	
}
