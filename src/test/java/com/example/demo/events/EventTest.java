package com.example.demo.events;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Spring test")
                .description("Spring REST API")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        // Given
        String name = "Event";
        String spring = "Spring";

        // When
        Event event = new Event();
        event.setName(name);
        event.setDescription(spring);

        // Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(spring);
    }

    @Test
    public void aseertJTest() {
        assertThat("123").isEqualTo("123")
                                .contains("2")
                                .endsWith("3");
    }
}