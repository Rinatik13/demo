package com.swimming.pool.demo.rest.controller;

import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.entity.Reserve;
import com.swimming.pool.demo.entity.TimeTable;
import com.swimming.pool.demo.service.client.ClientService;
import com.swimming.pool.demo.service.reserve.ReserveService;
import com.swimming.pool.demo.service.timetable.TimeTibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/v0/pool/timetable")
public class TimeController {

    @Autowired
    TimeTibleService timeTableService;

    @Autowired
    ClientService clientService;

    @Autowired
    ReserveService reserveService;

    @GetMapping("/all")
    public List<TimeTable> showAllTimeTable() {
        List<TimeTable> allTimeTable = timeTableService.getAllDateReg();
        return allTimeTable;
    }

    @GetMapping("/all/{string}")
    public TimeTable getAll(@PathVariable String string){
        List<TimeTable> timeTableList = timeTableService.getAllDateReg();
        for (TimeTable t:timeTableList){
            System.out.println(t.getTime().toString());
            if (t.getTime().equals(string)){
                return t;
            }
        }
        return null;
    }


    @PostMapping("/reserve")
    public Reserve reserve (@RequestBody Reserve reserve) {
        Client client = clientService.getClient(reserve.getClientId());
        TimeTable timeTable = timeTableService.getTableService(reserve.getDatetime());
        if (timeTable.getCount()<10){
            if (client!=null){
                reserveService.reserve(reserve);
                return reserve;
            }
        }
     return null;
    }

    @GetMapping("/available")
    public TimeTable getAvailable(){
        return null;
    }

    @GetMapping("/cancel/{}")

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
