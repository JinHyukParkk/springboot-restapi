package com.example.demo.events.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


// @RequiredArgsConstructor << 초기화되지 않은 final 필드나 @NonNull 이 붙은 필드에 생성자를 생성
//  - 상속 받은 클래스에 적용 X -> 인터페이스를 구현(implement)하는 경우 가능
//  - @Value 값으로 사용하려고 하는 경우 실수로 Bean으로 주입을 받으려는 현상
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull
    private LocalDateTime beginEventDateTime;
    @NotNull
    private LocalDateTime endEventDateTime;
    private String location;
    @Min(0)
    private int basePrice;
    @Min(0)
    private int maxPrice;
    @Min(0)
    private int limitOfEnrollment;
}
