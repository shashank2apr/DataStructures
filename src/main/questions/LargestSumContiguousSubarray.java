package main.questions;

import main.utilities.Utiltities;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {

		int[] arr = {2, -3, 4, -1, 2, 1, 5, -3};//Utiltities.inputArrayFromConsole();
		largestSumContiguousSubarray(arr);
		//maybeWrong(arr);
	}
	private static void largestSumContiguousSubarray(int[] arr) {
		// TODO Auto-generated method stub
		int currSum=0,sum=0,s=0,maxLength=0;
		for(int i =0;i<arr.length;i++){
			currSum=currSum+arr[i];
			if(currSum<0){
				currSum=0;
				s=i;
			}
			if(sum<currSum){
				sum=currSum;
				maxLength=i-s;
			}
		}
		
		System.out.println("Largest Sum of Continous SubArray = " + sum);
		System.out.println("Length of Largest Sum Continous SubArray = " + maxLength);
	}


	/**
	 * @param arr
	 */
	private static void maybeWrong(int[] arr) {
		int s = 0, e = 0, sum = 0, maxsum = 0,maxSubArrayLength=0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (maxsum < sum){
				maxsum = sum;
				maxSubArrayLength=e-s;
			}
				
			if (arr[i] < 0) {
				if (s == e && sum <0) {
					sum = 0;
					s++;
					e++;
				}  else if (sum < 0 && s!=e) {
					sum = 0;
					e++;
					s = e;
				}	else if (sum > 0) {
					e++;
				}

			} else {
				e++;
			}
		}
		System.out.println("Largest Sum of Continous SubArray = " + maxsum);
		System.out.println("Length of Largest Sum Continous SubArray = " + maxSubArrayLength);
	}


}
