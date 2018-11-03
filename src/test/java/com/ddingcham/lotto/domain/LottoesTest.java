package com.ddingcham.lotto.domain;

import org.junit.Assert;
import org.junit.Test;

public class LottoesTest {

	@Test
	public void get(){
		Lotto expected = Lotto.ofInt(1,2,3,4,5,6);
		Lottoes lottoes = new Lottoes(expected, Lotto.ofInt(7,8,9,3,1,2));
		
		Assert.assertEquals(expected, lottoes.get(0));
		Assert.assertNotEquals(expected, lottoes.get(1));
	}
	
	@Test
	public void add(){
		int expected = 1;
		Lottoes lottoes = new Lottoes(expected - 1);
		lottoes.add(Lotto.ofInt(1,2,3,4,5,6));
		
		Assert.assertEquals(expected, lottoes.size());
	}	
}
