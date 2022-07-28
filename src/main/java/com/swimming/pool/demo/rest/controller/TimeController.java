package com.swimming.pool.demo.rest.controller;

import com.swimming.pool.demo.entity.Order;
import com.swimming.pool.demo.entity.Reserve;
import com.swimming.pool.demo.entity.TimeTable;
import com.swimming.pool.demo.service.reserve.ReserveService;
import com.swimming.pool.demo.service.timetable.TimeTibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v0/pool/timetable")
public class TimeController {

    @Autowired
    TimeTibleService timeTableService;

    @Autowired
    ReserveService reserveService;

    @GetMapping("/all")
    public List<TimeTable> showAllTimeTable() {
        return timeTableService.getAllDateReg();
    }

    @GetMapping("/all/{string}")
    public TimeTable getAll(@PathVariable String string){
        return timeTableService.getDateReg(string);
    }

    @PostMapping("/reserve")
    public Order order (@RequestBody Reserve reserve) {
        Reserve reserve1 = reserveService.reserve(reserve);
        Order order = new Order();
        order.setOrderId(reserve.getOrderId() + "");
        return order;
    }

    @GetMapping("/available/{date}")
    public TimeTable getAvailable(@PathVariable String date){
        return timeTableService.getTableService(date);
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Reserve reserve){
        reserveService.cancel(reserve);
    }

    @RequestMapping("/")
    public void create() {
        reserveService.create();
    }
}
