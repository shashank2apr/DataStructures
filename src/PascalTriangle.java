import java.util.Scanner;


public class PascalTriangle {

	public static void main(String[] args) {
		
		
		
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		//printTrianglePascal(k);
		
		// A O(n^2) time and O(1) extra space function for Pascal's Triangle
		for (long n = 1; n <= k; n++)
		  {
		    long value = 1;  // used to represent C(line, i)
		    for (long r = 1; r <= n; r++)  
		    {
		      System.out.print(value+" ");  // The first value in a line is always 1
		      value = (value * (n - r) / r);
		      
		    }
		    System.out.println();
		  }
	}
	
	
}
