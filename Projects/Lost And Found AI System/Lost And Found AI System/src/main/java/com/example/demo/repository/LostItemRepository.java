package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LostItem;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {

}
