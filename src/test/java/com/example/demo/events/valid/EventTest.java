package com.example.demo.events.valid;

import com.example.demo.events.models.Event;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
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


    private Object[] parametersForTestFree() {   // parametersFor[테스트 메소드명] 컨벤션
        return new Object[] {
                new Object[] {0, 0, true},
                new Object[] {100, 0, false},
                new Object[] {0, 100, false},
                new Object[] {100, 200, false}
        };
    }
    @Test
//    @Parameters({
//            "0, 0, true",
//            "100, 0 , false",
//            "0, 100, false"
//    })
//    @Parameters(method = "parametersForTestFree")
    @Parameters
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();
        // JunitParam 을 사용해서 소스줄임

        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    @Test
    public void testOffline() {
        // Given
        Event event = Event.builder()
                .location("강남역 네이버 D2 스타텁 펙토리")
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isOffline()).isTrue();

        // Given
        event = Event.builder()
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isOffline()).isFalse();
    }
}