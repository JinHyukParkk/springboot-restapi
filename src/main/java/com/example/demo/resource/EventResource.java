package com.example.demo.resource;

import com.example.demo.models.Event;
import org.springframework.hateoas.RepresentationModel;

public class EventResource extends RepresentationModel {

    private Event event;

    public EventResource(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
