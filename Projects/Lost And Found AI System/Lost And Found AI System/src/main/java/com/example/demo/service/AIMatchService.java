package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AIMatchResult;
import com.example.demo.entity.FoundItem;
import com.example.demo.entity.LostItem;
import com.example.demo.repository.AIMatchResultRepository;
import com.example.demo.repository.FoundItemRepository;
import com.example.demo.repository.LostItemRepository;

@Service
public class AIMatchService {
	@Autowired
	private LostItemRepository lostRepo;

	@Autowired
	private FoundItemRepository foundRepo;

	@Autowired
	private AIMatchResultRepository matchRepo;

	public List<AIMatchResult> findMatches(Long lostItemId) {

		LostItem lost = lostRepo.findById(lostItemId).orElse(null);
		if (lost == null)
			return Collections.emptyList();

		List<FoundItem> foundItems = foundRepo.findAll();
		List<AIMatchResult> results = new ArrayList<>();

		for (FoundItem found : foundItems) {
			double score = calculateSimilarity(lost, found);

			if (score >= 40) { // threshold
				AIMatchResult result = new AIMatchResult();
				result.setLostItem(lost);
				result.setFoundItem(found);
				result.setLocationScore((float) score);
				results.add(matchRepo.save(result));
			}
		}
		return results;
	}

	private double calculateSimilarity(LostItem lost, FoundItem found) {
		String t1 = lost.getItemName() + " " + lost.getDescription() + " " + lost.getLocation();
		String t2 = found.getItemName() + " " + found.getDescription() + " " + found.getLocation();
		return cosineSimilarity(t1, t2) * 100;
	}

	private double cosineSimilarity(String text1, String text2) {
		Map<String, Integer> f1 = wordFrequency(text1);
		Map<String, Integer> f2 = wordFrequency(text2);

		Set<String> words = new HashSet<>();
		words.addAll(f1.keySet());
		words.addAll(f2.keySet());

		int dot = 0, mag1 = 0, mag2 = 0;

		for (String w : words) {
			int a = f1.getOrDefault(w, 0);
			int b = f2.getOrDefault(w, 0);
			dot += a * b;
			mag1 += a * a;
			mag2 += b * b;
		}
		return mag1 == 0 || mag2 == 0 ? 0 : dot / (Math.sqrt(mag1) * Math.sqrt(mag2));
	}

	private Map<String, Integer> wordFrequency(String text) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : text.toLowerCase().split("\\s+")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		return map;
	}
}
