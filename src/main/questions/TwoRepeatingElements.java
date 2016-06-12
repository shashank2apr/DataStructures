package main.questions;

public class TwoRepeatingElements {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 5, 2, 3, 1 };// Utiltities.inputArrayFromConsole();
		int n = 5;
		int xor = 0, sum = 0;
		for (int i = 0; i < arr.length; i++) {
			xor^=arr[i];
			sum += arr[i];
		}
		int naturalSum = (n * (n + 1)) / 2;
		int natXor=0;
		for (int i = 1; i <= n; i++) {
			natXor^=i;
		}
		
		System.out.println("Natural sum = " + naturalSum);
		System.out.println("Final sum is = " + sum);
		System.out.println("Actual - Natural Sum = " + (sum - naturalSum));
		System.out.println("XOR of XORed vals = "+Integer.toBinaryString(xor^natXor));
	}

}
