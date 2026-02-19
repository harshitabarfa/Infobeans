package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;

	private String eventName;
	private String organizerName;
	private String eventType;
	private String location;
	private double ticketPrice;
	private String status;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Event() {
		super();
	}

	public Event(Long eventId, String eventName, String organizerName, String eventType, String location,
			double ticketPrice, String status) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.organizerName = organizerName;
		this.eventType = eventType;
		this.location = location;
		this.ticketPrice = ticketPrice;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", organizerName=" + organizerName
				+ ", eventType=" + eventType + ", location=" + location + ", ticketPrice=" + ticketPrice + ", status="
				+ status + "]";
	}
}
