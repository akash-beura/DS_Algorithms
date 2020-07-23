package com.wityo.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static int findSubsequence(int[] arr) {

		int[] lengthArray = new int[arr.length];
		int[] sequence = new int[arr.length];

		
		for (int i = 0; i < arr.length; i++) {
			lengthArray[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					int newLength = lengthArray[j] + 1;
					lengthArray[i] = Math.max(lengthArray[i], newLength);
					sequence[i] = j;
				}
			}
		}

		

		
		int []result = new int[arr.length];
		
		for(int i =0;i<arr.length;i++){
			boolean zeroReached = false;
		    int sum = 0;
		    for(int j=i;j>=0;){
		    	if(j==0 && zeroReached){
		            break;
		        }
		        sum = sum + arr[j];
		        j = sequence[j];
		        if(j==0){
		            zeroReached = true;
		        }
		    }
		    result[i] = sum;
		}
		
		
	    int sum = -1;
	    for(int i=0;i<result.length;i++){
	        if(result[i]>sum){
	            sum = result[i];
	        }
	    }
		

		System.out.println(sum);
		return sum;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		int[] result = new int[T];
//		int p = 0;
//		while (T != 0) {
//			T--;
//			int size = Integer.parseInt(br.readLine());
//			String input[] = br.readLine().split("\\s");
//			int[] ar = new int[size];
//
//			for (int i = 0; i < input.length; i++) {
//				ar[i] = Integer.parseInt(input[i]);
//			}
//
//			result[p++] = findSubsequence(ar);
//		}
//		for (int i = 0; i < T; i++) {
//			System.out.println(result[i]);
//		}
		Float f1 = new Float("3.0");
		int x = f1.intValue();
		byte b = f1.byteValue();
		double d = f1.doubleValue();
		System.out.println(x+b+d);
		String s1 = "asbcd";
		char ch = 'a';
		ch++;
		System.out.println(ch);
	}
}
class A{
	private int x=1;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
} 

class B extends A{
	public B() {
		System.out.println(getX());
	}
}
