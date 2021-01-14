/* 
 * $RCSfile: ConvertPlusTest.java,v $ 
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
 * Support converting the digits from 0 to 99 into letters
 * 
 * @author climb
 *
 */

public class ConvertPlusTest {
	ConvertPlus convertPlus;

	@Before
	public void setUp() {
		convertPlus = new ConvertPlus();
	}

	@Test
	public void normalTest() {
		List<String> stringList = convertPlus.digitsLettersPlus(new int[] { 53, 8 });
		Assert.assertTrue(stringList.size() == 27);
	}

	@Test
	public void nullParamTest() {
		List<String> stringList = convertPlus.digitsLettersPlus(new int[] {});
		Assert.assertTrue(stringList.size() == 0);
	}

	@Test
	public void evilParamTest() {
		List<String> stringList = convertPlus.digitsLettersPlus(new int[] { -1, 100 });
		Assert.assertTrue(stringList.size() == 0);
	}

	@Test
	public void oneNumTest() {
		List<String> stringList = convertPlus.digitsLettersPlus(new int[] { 6 });
		Assert.assertTrue(stringList.size() == 3);
	}

	@Test
	public void nonMapTest() {
		List<String> stringList = convertPlus.digitsLettersPlus(new int[] { 0, 1, 23 });
		Assert.assertTrue(stringList.size() == 9);
	}

}
