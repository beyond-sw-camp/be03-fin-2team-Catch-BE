package com.encore.thecatch.event.controller;

import com.encore.thecatch.common.ResponseCode;
import com.encore.thecatch.common.dto.ResponseDto;
import com.encore.thecatch.common.util.IPUtil;
import com.encore.thecatch.event.dto.request.EventCreateDto;
import com.encore.thecatch.event.dto.response.EventSearchDto;
import com.encore.thecatch.event.service.EventService;
import com.encore.thecatch.mail.service.EmailSendService;
import com.encore.thecatch.notification.dto.EventNotificationReqDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class EventController {
    private final EventService eventService;

    private final EmailSendService emailSendService;

    public EventController(EventService eventService,
                           EmailSendService emailSendService) {
        this.eventService = eventService;
        this.emailSendService = emailSendService;
    }

    @PostMapping("/event/create")
    public ResponseDto eventCreate(@RequestBody EventCreateDto eventCreateDto, HttpServletRequest request) throws Exception {
        return new ResponseDto(HttpStatus.OK, ResponseCode.SUCCESS_EVENT_CREATE, eventService.eventCreate(eventCreateDto, IPUtil.getClientIP(request)));
    }

    @PostMapping("/eventList")
    public ResponseDto eventSearch(@RequestBody EventSearchDto eventSearchDto, Pageable pageable) throws Exception {
        return new ResponseDto(HttpStatus.OK, ResponseCode.SUCCESS, eventService.searchEvent(eventSearchDto, pageable));
    }

    @GetMapping("/event/{id}/detail")
    public ResponseDto adminDetail(@PathVariable Long id, HttpServletRequest request) throws Exception {
        return new ResponseDto(HttpStatus.OK, ResponseCode.SUCCESS_EVENT_DETAIL, eventService.eventDetail(id,IPUtil.getClientIP(request)));
    }

    @PatchMapping("/event/{id}/eventNotificationSend")
    public ResponseDto eventNotificationSend(@PathVariable Long id, @RequestBody EventNotificationReqDto eventNotificationReqDto) throws Exception {
        return new ResponseDto(HttpStatus.OK, ResponseCode.SUCCESS_PUBLISH_COUPON, eventService.createEventNotification(id, eventNotificationReqDto));
    }


}
