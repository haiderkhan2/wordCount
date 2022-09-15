package com.softstd.wordFrequency;

import java.util.Map;

public class Application {
	public static void main(String[] args) {

		String input = "the cat is in   the   bag  cat  ";
		Map<String, Long> wordCount = WordCountFrequencyUtil.findWordCountFrequnecy(input);
		wordCount.forEach((word, count) -> System.out.println((word + ":" + count)));
	}

}
