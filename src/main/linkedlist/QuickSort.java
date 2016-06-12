package main.linkedlist;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int arr[] = { 1, 5, 3, 2, 4, 45, 1, 23, 456, 21, 1, 23, 47, 89, 87, 67,
				54, 5, 67, 2, 567 };

		System.out.println("Before Sort:" + Arrays.toString(arr));
		quickSortRecursive(arr, 0, arr.length - 1);
		System.out.println("After Sort:" + Arrays.toString(arr));
	}

	private static void quickSortRecursive(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int p = partition(arr, start, end);
		//System.out.println(p);
		quickSortRecursive(arr, start, p - 1);
		quickSortRecursive(arr, p + 1, end);

	}

	private static int partition(int arr[], int start, int end) {

		int partitionIndex = start;
		int pivot = arr[end];
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(arr, partitionIndex, end);

		return partitionIndex;

	}

	// Find with XOR
	private static void swap(int[] arr, int i, int partitionIndex) {
		if (i != partitionIndex) {
			// System.out.println(arr[i]+" "+arr[partitionIndex]);
			arr[i] = arr[i] + arr[partitionIndex];
			// System.out.println(arr[i]+" "+arr[partitionIndex]);
			arr[partitionIndex] = arr[i] - arr[partitionIndex];
			// System.out.println(arr[i]+" "+arr[partitionIndex]);
			arr[i] = arr[i] - arr[partitionIndex];
			// System.out.println(arr[i]+" "+arr[partitionIndex]);
		}
	}
}
