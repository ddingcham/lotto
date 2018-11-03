package com.ddingcham.lotto;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.ddingcham.lotto.constant.DefaultValue;
import com.ddingcham.lotto.domain.Lottoes;
import com.ddingcham.lotto.domain.Money;

public class LottoFactoryTest {
	
	Money totalBudget;
	LottoFactory lottoFactory;
	
	@Before
	public void setUp(){
		totalBudget = new Money(5000);
		lottoFactory = new LottoFactory(totalBudget);
	}

	@Test
	public void 구입_가능_갯수(){
		Assertions.assertThat(lottoFactory.generateAllRandom().size()).isEqualTo(5);
	}
	
	@Test(expected=RuntimeException.class)
	public void 구입_가능_갯수_초과_구매_case_1(){
		lottoFactory.generateRandom(totalBudget.divide(DefaultValue.DEFAULT_LOTTO_PRICE)+1);
	}
	
	@Test(expected=RuntimeException.class)
	public void 구입_가능_갯수_초과_구매_case_2(){
		lottoFactory.generateAllRandom();
		lottoFactory.generateRandom();
	}

	// Moved From Lottoes
	@Test
	public void 로또_1장의_가격은_1000원이다_하나케이스(){
		int expected = 1;
		Lottoes actual = new LottoFactory(new Money(1000)).generateAllRandom();
		
		Assertions.assertThat(actual.size()).isEqualTo(expected);
	}

	// Moved From Lottoes
	@Test(expected = UnsupportedOperationException.class)
	public void 로또_1장의_가격은_1000원이다_1000원미만(){
		new LottoFactory(new Money(999)).generateRandom();
	}
}
