package com.example.event.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="events")
@Data
public class Event {
	
	@Id
	Long id;
	
	String eventName;
    LocalDate startingDate;
    LocalDate endDate;
    int quota;
    int participantNumber;

}
