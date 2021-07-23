package com.example.demo.events.vaild;

import com.example.demo.events.dto.EventDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void  validate(EventDto eventDto, Errors errors) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.rejectValue("basePrice", "wrongValue", "BasePrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong");
        }

        // TODO beginEventDateTime
        LocalDateTime beginEventDateTime = eventDto.getBeginEventDateTime();
        if (beginEventDateTime.isAfter(eventDto.getBeginEventDateTime())) {
            errors.rejectValue("beginEventDateTime", "wrongValue", "beginEventDateTime is wrong");
        }

        // TODO CloseEnrollmentDateTime
//        LocalDateTime closeEnrollmentDataTime = eventDto.getCloseEnrollmentDateTime();
//        if (closeEnrollmentDataTime.isAfter(eventDto.getBeginEventDateTime()) ||
//        closeEnrollmentDataTime.isBefore(eventDto.getBeginEnrollmentDateTime())||
//        closeEnrollmentDataTime.isAfter(eventDto.getEndEventDateTime())) {
//            errors.rejectValue("closeEnrollmentDataTime", "wrongValue", "closeEnrollmentDataTime is wrong");
//        }
//
//        LocalDateTime beginEnrollmentDateTime = eventDto.getBeginEnrollmentDateTime();
//        if (beginEnrollmentDateTime.isAfter(eventDto.getEndEventDateTime()) ||
//        beginEnrollmentDateTime.isAfter(eventDto.getCloseEnrollmentDateTime()) ||
//        beginEnrollmentDateTime.isAfter(eventDto.getBeginEventDateTime())) {
//            errors.rejectValue("beginEnrollmentDateTime", "wrongValue", "beginEnrollmentDateTime is wrong");
//        }
    }
}
