package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificationRepository;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepository notificationRepo;

	public Notification sendNotification(Notification notification) {
		return notificationRepo.save(notification);
	}

	public List<Notification> getAllNotifications() {
		return notificationRepo.findAll();
	}
}
