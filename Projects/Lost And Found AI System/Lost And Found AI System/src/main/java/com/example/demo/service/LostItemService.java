package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LostItem;
import com.example.demo.repository.LostItemRepository;

@Service
public class LostItemService {
	@Autowired
	private LostItemRepository lostItemRepo;

	public LostItem saveLostItem(LostItem item) {
		return lostItemRepo.save(item);
	}

	public List<LostItem> getAllLostItems() {
		return lostItemRepo.findAll();
	}

	public LostItem getLostItemById(Long id) {
		return lostItemRepo.findById(id).orElse(null);
	}

	public void deleteLostItem(Long id) {
		lostItemRepo.deleteById(id);
	}
}
