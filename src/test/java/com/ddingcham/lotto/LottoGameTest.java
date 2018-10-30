package com.ddingcham.lotto;

import org.junit.Assert;
import org.junit.Test;

public class LottoGameTest {

	@Test
	public void tokenizeAnswerNumbers(){
		Integer[] expected = {1, 2, 3, 4, 5, 6};
		Integer[] actual = LottoGame.tokenizeAnswerNumbers("1, 2, 3, 4, 5, 6");
		
		Assert.assertArrayEquals(expected, actual);
	}
	
}
