/* 
 * $RCSfile: ConvertPlus.java,v $ 
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
import java.util.Collections;
import java.util.List;

/**
 * Support converting the digits from 0 to 99 into letters
 * 
 * @author climb
 *
 */

public class ConvertPlus extends Convert {
	/**
	 * Support converting the digits from 0 to 99 into letters
	 * 
	 * @param ints  digits array
	 * @return All possible letter
	 */
	public List<String> digitsLettersPlus(int[] nums) {

		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}
		List<Integer> ints = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num > 99 || num < 0) {
				continue;
			}

			while (num >= 10) {
				ints.add(num % 10);
				num /= 10;
			}
			ints.add(num);
		}

		int[] integers = ints.stream().mapToInt(Integer::valueOf).toArray();
		return super.digitsLetters(integers);
	}

}
