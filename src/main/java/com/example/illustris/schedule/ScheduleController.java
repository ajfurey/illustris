package com.example.illustris.schedule;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    
    @GetMapping
	public List<Schedule> getSchedule(){
		return scheduleService.getSchedule();
	}

    @PostMapping()
    public void createNewAppt(@RequestBody Schedule schedule){
        scheduleService.createNewAppt(schedule);
    }
    
    @DeleteMapping(path= "{scheduleId}")
    public void deleteSchedule(@PathVariable("scheduleId") Long scheduleId){
        scheduleService.deleteSchedule(scheduleId);
    }

    @PutMapping(path ="{scheduleId}")
    public void updateSchedule(
        @PathVariable("scheduleId") Long scheduleId,
        @RequestParam(required = false) LocalDateTime apptTime,
        @RequestParam(required = false) Long patientId,
        @RequestParam(required = false) int orderId
    ){
        scheduleService.uadateSchedule(scheduleId, apptTime, patientId, orderId);
    }
}
