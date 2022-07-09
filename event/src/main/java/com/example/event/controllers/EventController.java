package com.example.event.controllers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.entities.Event;
import com.example.event.requests.EventCreateRequest;
import com.example.event.requests.EventUpdateRequest;
import com.example.event.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private EventService eventService;
	
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping
	public ResponseEntity<List<Event>> getAllPosts(){
		return eventService.getAllEvents();
	}
	
	@GetMapping("/{eventId}")
	public ResponseEntity<Event> getOnePost(@PathVariable Long eventId) {

		return eventService.getOneEvent(eventId);
	}
	
	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody EventCreateRequest newEventCreateRequest) {
		return eventService.createEvent(newEventCreateRequest);
	}
	
	@PutMapping("/{eventId}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody EventUpdateRequest updateEvent) {
		return eventService.updateEvent(eventId, updateEvent);
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
		return eventService.deleteEvent(eventId);

	}

}
