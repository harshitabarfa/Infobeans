package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Optional<Event> getEventById(Long id) {
		return eventRepository.findById(id);
	}

	public List<Event> getEventsByName(String name) {
		return eventRepository.findByEventNameIgnoreCase(name);
	}

	public List<Event> getEventsByLocation(String location) {
		return eventRepository.findByLocationIgnoreCase(location);
	}

	public List<Event> getEventsByType(String type) {
		return eventRepository.findByEventTypeIgnoreCase(type);
	}

	public List<Event> getEventsByStatus(String status) {
		return eventRepository.findByStatusIgnoreCase(status);
	}

	public Event updateEvent(Long id, Event eventDetails) {
		List<Event> eventList = eventRepository.findAll();

		Iterator<Event> iterator = eventList.iterator();
		while (iterator.hasNext()) {
			Event event = iterator.next();
			if (event.getEventId().equals(id)) {

				event.setEventName(eventDetails.getEventName());
				event.setOrganizerName(eventDetails.getOrganizerName());
				event.setEventType(eventDetails.getEventType());
				event.setLocation(eventDetails.getLocation());
				event.setTicketPrice(eventDetails.getTicketPrice());
				event.setStatus(eventDetails.getStatus());

				return eventRepository.save(event);
			}
		}
		return null;
	}

	public boolean deleteEvent(Long id) {
		if (eventRepository.existsById(id)) {
			eventRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Event> findByEventNameOrganizerTypeLocationPriceStatus(String eventName, String organizerName,
			String eventType, String location, Double ticketPrice, String status) {

		List<Event> allEvents = getAllEvents();
		List<Event> result = new ArrayList<>();

		for (Event event : allEvents) {

			boolean matchEventName = (eventName == null || eventName.isEmpty())
					|| event.getEventName().equalsIgnoreCase(eventName);

			boolean matchOrganizer = (organizerName == null || organizerName.isEmpty())
					|| event.getOrganizerName().equalsIgnoreCase(organizerName);

			boolean matchType = (eventType == null || eventType.isEmpty())
					|| event.getEventType().equalsIgnoreCase(eventType);

			boolean matchLocation = (location == null || location.isEmpty())
					|| event.getLocation().equalsIgnoreCase(location);

			boolean matchPrice = (ticketPrice == null || ticketPrice == 0)
					|| Double.compare(event.getTicketPrice(), ticketPrice) == 0;

			boolean matchStatus = (status == null || status.isEmpty()) || event.getStatus().equalsIgnoreCase(status);

			if (matchEventName && matchOrganizer && matchType && matchLocation && matchPrice && matchStatus) {
				result.add(event);
			}
		}
		return result;
	}
}