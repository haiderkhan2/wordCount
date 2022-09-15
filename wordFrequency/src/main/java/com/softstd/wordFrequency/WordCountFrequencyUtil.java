package com.softstd.wordFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordCountFrequencyUtil {

	static Logger logger = Logger.getLogger(WordCountFrequencyUtil.class.getName());

	public static Map<String, Long> findWordCountFrequnecy(String input) {

		Map<String, Long> wordCount = null;

		try {
			if (isValidString(input)) {
				input = input.trim().replaceAll("\\s+", " ");
				synchronized (WordCountFrequencyUtil.class) {
					List<String> wordsList = new ArrayList<String>(Arrays.asList(input.split(" ")));
					wordCount = wordsList.stream()
							.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

					wordCount = wordCount.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
							.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
									(entry1, entry2) -> entry2, LinkedHashMap::new));
				}
			}
		} catch (Exception e) {
			logger.info("String count operation failed for the string : " + input + " due to" + e.getMessage());
		}

		return wordCount;

	}

	public static boolean isValidString(String input) {
		return null != input && !input.trim().isEmpty();
	}

}
