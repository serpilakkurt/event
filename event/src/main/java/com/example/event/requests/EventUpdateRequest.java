package com.example.event.requests;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EventUpdateRequest {

	String eventName;
    LocalDate startingDate;
    LocalDate endDate;
    int quota;
    int participantNumber;
}
