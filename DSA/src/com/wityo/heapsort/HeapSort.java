package com.wityo.heapsort;

public class HeapSort {

	public void heapify(int[] a, int n, int i) {
		// assume i is the largest
		int largest = i;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;

		if (left < n && a[left] > a[largest])
			largest = left;
		if (right < n && a[right] > a[largest])
			largest = right;
		if (i != largest) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			// check for the subtree of the particular node you've heapified.
			heapify(a, n, largest);
		}
	}

	public void heapSort(int[] a) {
		int n = a.length;
		for (int i = n / 2; i >= 0; i--) {
			heapify(a, n, i);
		}
		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapify(a, i, 0);
		}
	}

	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public int delete(int[] a, int n) {
		// 1. find the last element in the array
		int lastElement = a[n - 1];
		// 2. Replace it with the root element.
		a[0] = lastElement;
		// reduce the size and heapify until the 2nd last element
		n = n - 1;
		heapify(a, n, 0);
		// return the new last index to be pointed to
		return n;
	}

	public void heapifyParticular(int[] a, int n, int i) {
		int parent = i / 2;
		if (parent >= 0 && a[parent] > a[i]) {
			int temp = a[parent];
			a[parent] = a[i];
			a[i] = temp;
			heapifyParticular(a, i, parent);
		}

	}

	public void insert(int[] a, int value) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				a[i] = value;
				heapifyParticular(a, a.length, i);
				break;
			}
		}

	}

	public static void main(String[] args) {
		String input = "1 0 1 2 1 1 0 0 1 2 1 2 1 2 1 0 0 1 1 2 2 0 0 2 2 2 1 1 1 2 0 0 0 2 0 1 1 1 1 0 0 0 2 2 1 2 2 2 0 2 1 1 2 2 0 2 2 1 1 0 0 2 0 2 2 1 0 1 2 0 0 0 0 2 0 2 2 0 2 1 0 0 2 2";
		String[] x = input.split("\\s");
		int a[] = new int[x.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(x[i]);
		}
		HeapSort hs = new HeapSort();
		hs.heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
