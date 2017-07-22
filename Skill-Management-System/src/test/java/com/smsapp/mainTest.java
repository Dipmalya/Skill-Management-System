package com.smsapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class mainTest {

	@Test
	public void allTest() {
		helloAllo hl = new helloAllo();
		boolean result = hl.yes;
		assertEquals(true,result);
	}

}
