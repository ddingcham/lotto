package com.ddingcham.lotto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ddingcham.lotto.domain.Lottoes;

public class LottoGeneratorTest {

	@Test
	public void 로또_1장의_가격은_1000원이다_하나케이스(){
		int expected = 1;
		Lottoes actual = LottoGenerator.generate(LottoGenerator.DEFAULT_LOTTO_PRICE);
		
		Assertions.assertThat(actual.size()).isEqualTo(expected);
	}
	
	@Test
	public void 로또_구입_금액을_입력하면_구입_금액에_해당하는_로또를_발급해야_한다(){
		int expected = 5;
		int price = LottoGenerator.DEFAULT_LOTTO_PRICE * expected;
		Lottoes actual = LottoGenerator.generate(price);
		
		Assertions.assertThat(actual.size()).isEqualTo(expected);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void 로또_1장의_가격은_1000원이다_1000원미만(){
		final int price = LottoGenerator.DEFAULT_LOTTO_PRICE - 1;
		LottoGenerator.generate(price);
	}
	
}
