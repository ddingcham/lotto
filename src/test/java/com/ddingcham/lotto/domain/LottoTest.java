package com.ddingcham.lotto.domain;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class LottoTest {
	
	@Test
	public void 일치_여부_검사(){
		Lotto lotto = generateLotto(1,2,3,4,5,6);
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(lotto.matchCount(generateLotto(1,11,10,9,8,7)))
		.as("1개 일치").isEqualTo(1);
		softly.assertThat(lotto.matchCount(generateLotto(1,2,10,9,8,7)))
		.as("2개 일치").isEqualTo(2);
		softly.assertThat(lotto.matchCount(generateLotto(1,2,3,9,8,7)))
		.as("3개 일치").isEqualTo(3);
		softly.assertThat(lotto.matchCount(generateLotto(1,2,3,4,8,7)))
		.as("4개 일치").isEqualTo(4);
		softly.assertThat(lotto.matchCount(generateLotto(1,2,3,4,5,7)))
		.as("5개 일치").isEqualTo(5);
		softly.assertThat(lotto.matchCount(generateLotto(1,2,3,4,5,6)))
		.as("6개 일치").isEqualTo(6);
		
		softly.assertAll();
	}
	
	private Lotto generateLotto(Integer... numbers){
		Set<LottoNumber> lottoNumbers = new HashSet<LottoNumber>();
		for(int number : numbers){
			lottoNumbers.add(new LottoNumber(number));
		}
		return new Lotto(lottoNumbers);
	}

}