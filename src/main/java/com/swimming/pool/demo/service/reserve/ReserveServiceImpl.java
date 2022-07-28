package com.swimming.pool.demo.service.reserve;

import com.swimming.pool.demo.dao.client.ClientDaO;
import com.swimming.pool.demo.dao.reserve.ReserveDaO;
import com.swimming.pool.demo.dao.timetable.TimeTableDaO;
import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.entity.Reserve;
import com.swimming.pool.demo.entity.TimeTable;
import com.swimming.pool.demo.service.client.ClientService;
import com.swimming.pool.demo.service.timetable.TimeTibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService{

    @Autowired
    ReserveDaO reserveDaO;

    @Autowired
    TimeTableDaO timeTableDaO;

    @Autowired
    ClientDaO clientDaO;

    @Autowired
    ClientService clientService;

    @Autowired
    TimeTibleService timeTableService;

    @Override
    @Transactional
    public Reserve reserve(Reserve reserve) {
        Client client = clientService.getClient(reserve.getClientId());
        TimeTable timeTable = timeTableService.getTableService(reserve.getDatetime());
        if (timeTable.getCount()<10){
            if (client!=null){
                timeTable.setCount(timeTable.getCount()+1);
                timeTableService.saveDateReg(timeTable);
                reserveDaO.reserve(reserve);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void cancel(Reserve reserve) {
        Reserve reserve1 = reserveDaO.getReserve(reserve);
        TimeTable timeTable = timeTableService.getTableService(reserve1.getDatetime());
        if (timeTable.getCount()>0){
            timeTable.setCount(timeTable.getCount()-1);
            reserveDaO.cancel(reserve);
            timeTableService.saveDateReg(timeTable);
        }
    }

    @Override
    @Transactional
    public Reserve getReserve(Reserve reserve) {
        return reserveDaO.getReserve(reserve);
    }

    @Override
    @Transactional
    public List<Reserve> getAll() {
        return reserveDaO.getAll();
    }

    @Override
    public void create() {
        if (timeTableService.getAllDateReg().size()<1){
            Calendar cal = new GregorianCalendar();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
            for (int i = 0; i < 30; i++) {
                cal.add(Calendar.DAY_OF_WEEK, 1);
                if (cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
                    i--;
                } else if (cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
                    i--;
                }
                else
                {
                    String result = sf.format(cal.getTime());
                    for (int a = 8; a < 21; a++) {
                        String res = result + "." + a;
                        TimeTable tb = new TimeTable();
                        tb.setTime(res);
                        tb.setCount(0);
                        timeTableService.saveDateReg(tb);
                    }
                }
            }

        }
    }
}
