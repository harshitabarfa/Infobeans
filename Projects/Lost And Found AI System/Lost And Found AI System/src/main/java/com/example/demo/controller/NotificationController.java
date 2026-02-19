package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Notification;
import com.example.demo.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping
	public Notification send(@RequestBody Notification notification) {
		return notificationService.sendNotification(notification);
	}

	@GetMapping
	public List<Notification> getAll() {
		return notificationService.getAllNotifications();
	}
}
