package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Event;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<List<Event>> getAllEvents() {
		List<Event> events = eventService.getAllEvents();
		if (events.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(events);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEventById(@PathVariable Long id) {
		Optional<Event> event = eventService.getEventById(id);
		if (event.isPresent()) {
			return ResponseEntity.ok(event.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found!");
		}
	}

	@GetMapping("/name/{eventName}")
	public ResponseEntity<?> getEventsByName(@PathVariable String eventName) {
		List<Event> list = eventService.getEventsByName(eventName);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/location/{location}")
	public ResponseEntity<?> getEventsByLocation(@PathVariable String location) {
		List<Event> list = eventService.getEventsByLocation(location);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/type/{eventType}")
	public ResponseEntity<?> getEventsByType(@PathVariable String eventType) {
		List<Event> list = eventService.getEventsByType(eventType);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<?> getEventsByStatus(@PathVariable String status) {
		List<Event> list = eventService.getEventsByStatus(status);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEvent(@PathVariable Long id, @RequestBody Event event) {
		Event updated = eventService.updateEvent(id, event);
		if (updated != null) {
			return ResponseEntity.ok("Event updated successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found!");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
		boolean deleted = eventService.deleteEvent(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Event deleted successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found!");
		}
	}

	@GetMapping("/search")
	public ResponseEntity<List<Event>> searchEvents(@RequestParam(required = false) String eventName,
			@RequestParam(required = false) String organizerName, @RequestParam(required = false) String eventType,
			@RequestParam(required = false) String location, @RequestParam(required = false) Double ticketPrice,
			@RequestParam(required = false) String status) {

		List<Event> result = eventService.findByEventNameOrganizerTypeLocationPriceStatus(eventName, organizerName,
				eventType, location, ticketPrice, status);

		return ResponseEntity.ok(result);
	}
}
