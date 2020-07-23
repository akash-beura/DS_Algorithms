package com.wityo.mergesort;

public class QuickSort {

	public int partition(int[] a, int start, int end) {
		int pivot = end;
		int pIndex = start;

		for (int i = start; i < end; i++) {
			if (a[i] <= a[pivot]) {
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = a[pivot];
		a[pivot] = a[pIndex];
		a[pIndex] = temp;
		return pIndex;
	}

	public void quickSort(int[] a, int start, int end) {
		if (start<end) {
			int pIndex = partition(a, start, end);
			quickSort(a, start, pIndex - 1);
			quickSort(a, pIndex + 1, end);
		}
	}
	
	public static void main(String[] args) {
		int []a = {4,3,2,1};
		new QuickSort().quickSort(a, 0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
