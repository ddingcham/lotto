package com.ddingcham.lotto;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

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
		lottoFactory.generateRandom(totalBudget.divide(LottoFactory.DEFAULT_PRICE)+1);
	}
	
	@Test(expected=RuntimeException.class)
	public void 구입_가능_갯수_초과_구매_case_2(){
		lottoFactory.generateAllRandom();
		lottoFactory.generateRandom();
	}
}
