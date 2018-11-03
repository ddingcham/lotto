package com.ddingcham.lotto.domain;

import org.junit.Test;

public class LottoNumberTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void 로또를_구성하는_숫자가_1미만인_경우(){
		LottoNumber.ofInt(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void 로또를_구성하는_숫자가_45초과인_경우(){
		LottoNumber.ofInt(46);
	}
	
}