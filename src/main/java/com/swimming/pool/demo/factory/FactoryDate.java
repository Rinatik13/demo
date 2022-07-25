package com.swimming.pool.demo.factory;

import com.swimming.pool.demo.entity.TimeTable;

public class FactoryDate {
    public static TimeTable create(String time){
        TimeTable date = new TimeTable();
        date.setTime(time);
        date.setCount((byte) 0);
        return date;
    }
}
