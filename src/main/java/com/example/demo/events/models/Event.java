package com.example.demo.events.models;

import com.example.demo.accounts.Account;
import com.example.demo.accounts.AccountSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity @Table(name = "event")
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

    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    private Account manager;

    // free, offline 여부 체크
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
    // ######################################
    // # basePrice    maxPrice      설명     #
    // #     0          100       선착순 등록  #
    // #     0           0          무료     #
    // #    100          0        무제한 경매  #
    // #    100         200      제한가 선착순  #
    // ######################################
}
