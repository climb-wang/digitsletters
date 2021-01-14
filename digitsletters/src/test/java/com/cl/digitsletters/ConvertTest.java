/* 
 * $RCSfile: ConvertTest.java,v $ 
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

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Convert the digits from 0 to 9 into letters
 * 
 * @author climb
 *
 */

public class ConvertTest {

	Convert convert;

	@Before
	public void setUp() {
		convert = new Convert();
	}

	@Test
	public void normalTest() {
		List<String> stringList = convert.digitsLetters(new int[] { 5, 3, 9 });
		Assert.assertTrue(stringList.size() == 36);
	}

	@Test
	public void nullParamTest() {
		List<String> stringList = convert.digitsLetters(new int[] {});
		Assert.assertTrue(stringList.size() == 0);
	}

	@Test
	public void evilParamTest() {
		List<String> stringList = convert.digitsLetters(new int[] { -1, 10 });
		Assert.assertTrue(stringList.size() == 0);
	}

	@Test
	public void oneNumTest() {
		List<String> stringList = convert.digitsLetters(new int[] { 6 });
		Assert.assertTrue(stringList.size() == 3);
	}

	@Test
	public void nonMapTest() {
		List<String> stringList = convert.digitsLetters(new int[] { 0, 1, 2, 3 });
		Assert.assertTrue(stringList.size() == 9);
	}
}
