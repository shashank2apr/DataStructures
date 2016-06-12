package main.questions;

import java.util.Scanner;

import main.utilities.Utiltities;

public class MajorityElement {

	public static void main(String[] args) {

		int[] arr = Utiltities.inputArrayFromConsole();

		int candidate = findCandidate(arr.length, arr);

		int majorityElement = countOfCandidate(arr.length, arr, candidate);
		if (majorityElement > (arr.length) / 2) {
			System.out.println("Majority Element is : " + candidate);
			return;
		}
		System.out.println("No majority element Found");
	}

	/**
	 * @param length
	 * @param arr
	 * @param candidate
	 */
	private static int countOfCandidate(int length, int[] arr, int candidate) {
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] == candidate)
				count++;
		}
		return count;
	}

	/**
	 * @param length
	 * @param arr
	 */
	private static int findCandidate(int length, int[] arr) {
		// # Step 1 - Find the probable candidate element.
		// # Step 2 - If count of probable > length/2 of arr then return that
		// candidate as Majority element.
		// At start, consider first element as probable candidate
		int count = 1, majority_index = 0;
		for (int i = 1; i < length; i++) {
			if (arr[majority_index] == arr[i]) {
				count++;
			} else {
				count--;
			}
			if (count < 1)
				majority_index = i;
		}// for loop ends

		return arr[majority_index];

	}

}
