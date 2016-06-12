package main.utilities;

import java.util.Scanner;

public class Utiltities {
	/**
	 * @return
	 */
	public static int[] inputArrayFromConsole() {
		Scanner sc = new Scanner(System.in);
		int length = inputLengthofArray(sc);
		int arr[] = null;
		arr = new int[length];

		for (int i = 0; i < length; i++) {
			System.out.println("Please enter element : ");
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	/**
	 * @param sc
	 * @return
	 */
	private static int inputLengthofArray(Scanner sc) {
		int length = 0;
		System.out.println("Please enter the length of string :");
		if (sc.hasNextInt())
			length = sc.nextInt();
		else
			length = 4;
		return length;
	}


}
