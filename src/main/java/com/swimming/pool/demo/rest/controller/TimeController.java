package com.swimming.pool.demo.rest.controller;

import com.swimming.pool.demo.entity.TimeTable;
import com.swimming.pool.demo.service.timetable.TimeTibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("api/v0/pool/timetable")
public class TimeController {

    @Autowired
    TimeTibleService timeTableService;

    @GetMapping("/all")
    public List<TimeTable> showAllTimeTable() {
        List<TimeTable> allTimeTable = timeTableService.getAllDateReg();
        return allTimeTable;
    }

    @RequestMapping("/")
    public void create() {

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd.HH");
        if (timeTableService.getAllDateReg().size() != (30 * 8)) {
            for (int i = 1; i < 31; i++) {
                TimeTable tb = new TimeTable();
                calendar.set(Calendar.DATE, i);
                for (int a = 8; a < 17; a++) {
                    calendar.set(calendar.HOUR, a);
                    tb.setTime(sf.format(calendar.getTime()));
                    tb.setCount(0);
                    timeTableService.saveDateReg(tb);
                }
            }
        }
    }
}
