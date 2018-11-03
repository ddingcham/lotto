package com.ddingcham.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;



public class MoneyTest {

	@Test(expected=IllegalArgumentException.class)
	public void 생성_제약_사항(){
		new Money(0);
	}
	
	@Test
	public void divide(){
		Money dividedMoney = new Money(5700);
		Money divider = new Money(1000);
		
		Assertions.assertThat(dividedMoney.divide(divider)).isEqualTo(5);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void divide_unssurported(){
		Money dividedMoney = new Money(100);
		Money divider = new Money(1000);
		dividedMoney.divide(divider);
	}
	
}