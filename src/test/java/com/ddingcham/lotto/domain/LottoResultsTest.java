package com.ddingcham.lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import com.ddingcham.lotto.constant.DefaultValue;

public class LottoResultsTest {
	
	LottoResults lottoResults;
	
	@Before
	public void setUp(){		
		lottoResults = new LottoResults(Rank.FIFTH, Rank.MISS);
	}
	
	@Test
	public void count(){
		SoftAssertions softly = new SoftAssertions();
		
		softly.assertThat(lottoResults.count(Rank.FIFTH)).isEqualTo(1);
		softly.assertThat(lottoResults.count(Rank.MISS)).isEqualTo(1);
		softly.assertThat(lottoResults.count(Rank.FIRST)).isEqualTo(0);
		softly.assertThat(lottoResults.count(Rank.THIRD)).isEqualTo(0);
		
		softly.assertAll();
	}
	
	@Test
	public void add(){
		lottoResults.add(Rank.FIFTH);
		
		Assertions.assertThat(lottoResults.count(Rank.FIFTH)).isEqualTo(2);
	}

	@Test
	public void calculateProfitRate(){
		double actual = lottoResults.calculateProfitRate(DefaultValue.DEFAULT_LOTTO_PRICE);
		Assertions.assertThat(actual).isEqualTo(250);
	}
	
}
