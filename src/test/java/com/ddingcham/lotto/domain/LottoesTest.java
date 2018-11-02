package com.ddingcham.lotto.domain;

import org.assertj.core.api.Assertions;
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
	public void 로또_1장의_가격은_1000원이다_하나케이스(){
		int expected = 1;
		Lottoes actual = Lottoes.generate(Lottoes.DEFAULT_LOTTO_PRICE);
		
		Assertions.assertThat(actual.size()).isEqualTo(expected);
	}
	
	@Test
	public void 로또_구입_금액을_입력하면_구입_금액에_해당하는_로또를_발급해야_한다(){
		int expected = 5;
		int price = Lottoes.DEFAULT_LOTTO_PRICE * expected;
		Lottoes actual = Lottoes.generate(price);
		
		Assertions.assertThat(actual.size()).isEqualTo(expected);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void 로또_1장의_가격은_1000원이다_1000원미만(){
		final int price = Lottoes.DEFAULT_LOTTO_PRICE - 1;
		Lottoes.generate(price);
	}
	
	
}
