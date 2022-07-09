package com.example.event.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
