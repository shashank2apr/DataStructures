package main.questions;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangleOverlap {
	 public static void main(String[] args) throws IOException {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    String[] inp;
		    int[] arr = new int[8];
		    int ctr=0;
		    while ((s = in.readLine()) != null) {
		    	ctr=0;
		    	inp=s.split("\\s+");
		    	for(String str:inp){
		    		arr[ctr++]=Integer.parseInt(str);
		    	}
		    	Rectangle rect1=new Rectangle(arr[0], arr[1]+arr[3], arr[2],arr[3]);
		    	Rectangle rect2=new Rectangle(arr[4], arr[5]+arr[7], arr[6],arr[7]);
		    	//System.out.println(rect1.intersects(rect2));
		      System.out.println(Rectoverlap(rect1,rect2));
		      
		    }
		  }

	private static boolean Rectoverlap(Rectangle r1, Rectangle r2) {
		
		boolean res=false;
		
		if(r1==null || r2== null)
			return res;
		if( ( (r2.x+r2.width) < r1.x ) || ( (r1.x+r1.width) < r2.x) ){
			res=false;
		} else if( ( (r2.y+r2.height) < r1.y ) || ( (r1.y+r1.height) < r2.y) ){
			res=false;
		} else{
			res=true;
		}
		
		
		return res;
	}

}
