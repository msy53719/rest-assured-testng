package com.mosy.test.printtest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHee {
	@Test
	public void testopr() {
		System.out.println("1111");
	}

	@Test
	public void testotpr() {
		System.out.println("22222".equals("1"));
		Assert.assertEquals(false, true);
	}

	@Test
	public void testotpRRr() {
		System.out.println("333".equals("ST"));
		getClass();
		Assert.assertEquals(false, true);

	}
}
