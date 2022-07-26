package com.swimming.pool.demo.dao.timetable;

import com.swimming.pool.demo.entity.TimeTable;

import java.util.List;

public interface TimeTableDaO {
    public List<TimeTable> getAllDateReg();

    public void saveDateReg(TimeTable dateReg);

    public TimeTable getDateReg(int id);

    public void delete(int id);

    public TimeTable getTime(String string);
}
