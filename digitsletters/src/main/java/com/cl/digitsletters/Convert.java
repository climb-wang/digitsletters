/* 
 * $RCSfile: Convert.java,v $ 
 * $Revision: 1.1  $ 
 * $Date: 2021年1月14日  $ 
 * 
 * Copyright (C) 2014 NearBound, Inc. All rights reserved. 
 * 
 * This software is the proprietary information of NearBound, Inc. 
 * Use is subject to license terms. 
 */

/**
 * 
 */
package com.cl.digitsletters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert the digits from 0 to 9 into letters
 * 
 * @author climb
 *
 */

public class Convert {

	Map<Integer, char[]> keyboardMapping = new HashMap<>();

	{
		keyboardMapping.put(0, new char[0]);
		keyboardMapping.put(1, new char[0]);
		keyboardMapping.put(2, new char[] { 'a', 'b', 'c' });
		keyboardMapping.put(3, new char[] { 'd', 'e', 'f' });
		keyboardMapping.put(4, new char[] { 'g', 'h', 'i' });
		keyboardMapping.put(5, new char[] { 'j', 'k', 'l' });
		keyboardMapping.put(6, new char[] { 'm', 'n', 'o' });
		keyboardMapping.put(7, new char[] { 'p', 'q', 'r', 's' });
		keyboardMapping.put(8, new char[] { 't', 'u', 'v' });
		keyboardMapping.put(9, new char[] { 'w', 'x', 'y', 'z' });
	}

	/**
	 * Support converting the digits from 0 to 9 into letters
	 *
	 * @param nums  digits array
	 * @return All possible letters
	 */
	public List<String> digitsLetters(int[] nums) {

		List<String> letterList = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return letterList;
		}

		List<char[]> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num > 9 || num < 0) {
				continue;
			}
			char[] chars = keyboardMapping.get(num);
			if (chars.length > 0) {
				list.add(chars);
			}
		}

		if (list.isEmpty()) {
			return letterList;
		}

		letterList = combine(list);
		return letterList;
	}

	/**
	 * Combine Letters
	 *
	 * @param chars
	 * @return
	 */
	private List<String> combine(List<char[]> chars) {

		char[] remove = chars.remove(0);
		List<String> list = new ArrayList<>();
		if (chars.size() == 0) {
			for (int i = 0; i < remove.length; i++) {
				list.add("" + remove[i]);
			}
			return list;
		}
		List<String> strings = combine(chars);
		for (int i = 0; i < remove.length; i++) {
			for (int j = 0; j < strings.size(); j++) {
				list.add(remove[i] + strings.get(j));
			}
		}
		return list;
	}

}
