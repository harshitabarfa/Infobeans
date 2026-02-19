package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FoundItem;
import com.example.demo.repository.FoundItemRepository;

@Service
public class FoundItemService {
	@Autowired
	private FoundItemRepository foundItemRepo;

	public FoundItem saveFoundItem(FoundItem item) {
		return foundItemRepo.save(item);
	}

	public List<FoundItem> getAllFoundItems() {
		return foundItemRepo.findAll();
	}

	public FoundItem getFoundItemById(Long id) {
		return foundItemRepo.findById(id).orElse(null);
	}

	public void deleteFoundItem(Long id) {
		foundItemRepo.deleteById(id);
	}
}
