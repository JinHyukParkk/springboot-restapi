package com.example.demo.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;

    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {
        // Updaste free
        if (this.basePrice == 0 && this.maxPrice == 0) {
            this.free = true;
        } else {
            this.free = false;
        }

        // Update offline
        if (this.location == null || this.location.isBlank()) {      // isBlank << Java 11 에서부터 추가 trim, empty 체크
            this.offline = false;
        } else {
            this.offline = true;
        }
    }
}
