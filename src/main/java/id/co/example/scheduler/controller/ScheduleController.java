package id.co.example.scheduler.controller;

import id.co.example.scheduler.schedule.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private Schedule schedule;

    @GetMapping(value = "api/v1/schedule")
    public ResponseEntity<Object> checkResponseActiveStatus() {
        String cronExpression = "0/5 * * * * ?";
        schedule.scheduleExpressionFromParameter(cronExpression);
        return new ResponseEntity<>("Schedule has been add", HttpStatus.OK);
    }

}
