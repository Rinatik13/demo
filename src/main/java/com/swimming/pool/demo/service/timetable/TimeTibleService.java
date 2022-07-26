package com.swimming.pool.demo.service.timetable;

import com.swimming.pool.demo.entity.TimeTable;

import java.util.List;

public interface TimeTibleService {
    public List<TimeTable> getAllDateReg();

    public void saveDateReg(TimeTable dateReg);

    public TimeTable getDateReg(int id);

    public void deleteDateReg(int id);

    public TimeTable getTableService(String string);
}
