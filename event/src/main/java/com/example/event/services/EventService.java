package com.example.event.services;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.event.entities.Event;
import com.example.event.repos.EventRepository;
import com.example.event.requests.EventCreateRequest;
import com.example.event.requests.EventUpdateRequest;


@Service
public class EventService {
	
	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository= eventRepository;
	}
	
	public ResponseEntity<List<Event>>  getAllEvents() {
		return new ResponseEntity<List<Event>>(eventRepository.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<Event> getOneEvent(Long eventId) {
		return new ResponseEntity<Event>(eventRepository.findById(eventId).orElse(null),HttpStatus.OK);
	}
	
	public ResponseEntity<Event> createEvent(EventCreateRequest newEventCreateRequest) {
	
		Event event = new Event();
		event.setId(newEventCreateRequest.getId());
		event.setEventName(newEventCreateRequest.getEventName());
		event.setStartingDate(newEventCreateRequest.getStartingDate());
		event.setEndDate(newEventCreateRequest.getEndDate());
		event.setQuota(newEventCreateRequest.getQuota());
		event.setParticipantNumber(newEventCreateRequest.getParticipantNumber());
		return new ResponseEntity<Event>(eventRepository.save(event), HttpStatus.OK);
		}
		
	public ResponseEntity<Event> updateEvent(Long eventId, EventUpdateRequest updateEvent) {
		
		Event event = getOneEvent(eventId).getBody();
		if(event == null)
			return null;
		else {
			event.setEventName(updateEvent.getEventName());
			event.setStartingDate(updateEvent.getStartingDate());
			event.setEndDate(updateEvent.getEndDate());
			event.setQuota(updateEvent.getQuota());
			event.setParticipantNumber(updateEvent.getParticipantNumber());
			return new ResponseEntity<Event>(eventRepository.save(event), HttpStatus.OK);		}
		
	}
	
	public ResponseEntity<String> deleteEvent(Long eventId) {
		   eventRepository.deleteById(eventId);
			return new ResponseEntity<String>(HttpStatus.OK);

	}
}
