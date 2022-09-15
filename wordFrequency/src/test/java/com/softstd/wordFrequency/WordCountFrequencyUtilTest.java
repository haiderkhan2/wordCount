package com.softstd.wordFrequency;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountFrequencyUtilTest {

	private Map<String, Long> wordCount;
	private String input;

	@Before
	public void set() {
		input = "the cat is in the bag";
	}

	@Test
	public void findWordCountFrequnecyTest() {
		wordCount = WordCountFrequencyUtil.findWordCountFrequnecy(input);
		Assert.assertNotNull(wordCount);
		long bagCount = Long.valueOf(wordCount.get("bag"));
		long theCount = Long.valueOf(wordCount.get("the"));
		Assert.assertEquals(bagCount, 1);
		Assert.assertEquals(theCount, 2);
	}

	@Test
	public void findWordCountFrequnecyTestWithNullString() {
		input = null;
		wordCount = WordCountFrequencyUtil.findWordCountFrequnecy(input);
		Assert.assertNull(wordCount);
	}

	@Test
	public void findWordCountFrequnecyTestWithEmptyString() {
		input = "";
		wordCount = WordCountFrequencyUtil.findWordCountFrequnecy(input);
		Assert.assertNull(wordCount);
	}
}
