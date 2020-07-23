package com.wityo.mergesort;

public class MergeSort {

	public static int[] merge(int left[], int right[], int arr[]) {
		int leftEnd = left.length;
		int rightEnd = right.length;
		int i, j, k;
		i = j = k = 0;

		while (i < leftEnd && j < rightEnd) {
			if (left[i] < right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < leftEnd) {
			arr[k++] = left[i++];
		}
		while (j < rightEnd) {
			arr[k++] = right[j++];
		}
		return arr;
	}

	public static void mSort(int[] arr) {
		if (arr.length > 1) {
			int mid = arr.length / 2;
			int left[] = new int[mid];
			int right[] = new int[arr.length - mid];
			int i = 0;
			for (i = 0; i < mid; i++) {
				left[i] = arr[i];

			}
			for (; i < arr.length; i++) {
				right[i - mid] = arr[i];
			}
			mSort(left);
			mSort(right);
			merge(left, right, arr);
			System.out.println("pass");
			for (i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");

		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 1, 10 };
		mSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
