package com.swimming.pool.demo.service.timetable;

import com.swimming.pool.demo.dao.timetable.TimeTableDaO;
import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.entity.TimeTable;
import com.swimming.pool.demo.service.reserve.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTibleService {

    @Autowired
    private Client client;

    @Autowired
    private TimeTableDaO dateRegDaO;

    @Autowired
    private ReserveService reserveService;

    @Override
    @Transactional
    public List<TimeTable> getAllDateReg() {
        return dateRegDaO.getAllDateReg();
    }

    @Override
    @Transactional
    public void saveDateReg(TimeTable dateReg) {
        dateRegDaO.saveDateReg(dateReg);
    }

    @Override
    @Transactional
    public TimeTable getDateReg(int id) {
        return dateRegDaO.getDateReg(id);
    }

    @Override
    @Transactional
    public void deleteDateReg(int id) {
        dateRegDaO.delete(id);
    }

    @Override
    @Transactional
    public TimeTable getTableService(String string) {
        return dateRegDaO.getTime(string);
    }

    @Override
    @Transactional
    public TimeTable getDateReg(String string) {
        List<TimeTable> timeTablesList = dateRegDaO.getAllDateReg();
        for (TimeTable t:timeTablesList){
            if (t.getTime().equals(string)){
                return t;
            }
        }
        return null;
    }

}
