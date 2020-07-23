package com.wityo.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test implements Comparator<Test> {

	public int minStartValue(int[] nums) {

		int i = 0, j = 1;
		int initialStart = j;
		while (i < nums.length) {
			if (nums[i] + j >= 1) {
				i++;
			} else {
				initialStart = initialStart + 1;
				j = initialStart;
				i = 0;
			}
		}
		return initialStart;
	}

	public static void main(String[] args) {
		int num = 10;
		System.out.println(-num);
		Map<String, Integer> s1 = new TreeMap<>((o1, o2)-> o1.compareTo(o2));
//		s1.put("dss", s1.get)
	}

	@Override
	public int compare(Test o1, Test o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
