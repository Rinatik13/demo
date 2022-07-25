package com.swimming.pool.demo.rest.controller;

import com.swimming.pool.demo.entity.TimeTable;
import com.swimming.pool.demo.service.timetable.TimeTibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("api/v0/pool/timetable")
public class TimeController {

    @Autowired
    TimeTibleService timeTableService;

    @GetMapping("/all")
    public List<TimeTable> showAllTimeTable (){
        List<TimeTable> allTimeTable = timeTableService.getAllDateReg();
        return allTimeTable;
    }

    @RequestMapping("/create")
    public void create(){

        for (int i = 0; i<30; i++){
            TimeTable tb = new TimeTable();
            tb.setTime("1" + i);
            tb.setCount(0);
            timeTableService.saveDateReg(tb);
        }


    }

}
