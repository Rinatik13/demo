package com.swimming.pool.demo.factory;

import com.swimming.pool.demo.entity.DateReg;

public class FactoryDate {
    public static DateReg create(String time){
        DateReg date = new DateReg();
        date.setTime(time);
        date.setCount((byte) 0);
        return date;
    }
}
