
public class MaxDiffInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={6,
				7,
				9,
				5,
				6,
				3,
				2};
		 System.out.println(maxDiff(a,a.length));
		 
}
	static int maxDiff (int a[], int n)
	{
	    
	    int currDiff = a[1]-a[0];
	    int sum = currDiff;
	    int maxSum = -1;
	 
	    for(int i=1; i<n-1; i++)
	    {
	        
	        currDiff = a[i+1]-a[i];
	        if (sum > 0)
	           sum += currDiff;
	        else
	           sum = currDiff;
	        if (sum > maxSum)
	           maxSum = sum;
	    }
	 
	    return maxSum;
	}
}


