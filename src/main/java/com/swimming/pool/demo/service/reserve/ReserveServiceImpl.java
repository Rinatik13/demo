package com.swimming.pool.demo.service.reserve;

import com.swimming.pool.demo.dao.reserve.ReserveDaO;
import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.entity.Reserve;
import com.swimming.pool.demo.entity.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReserveServiceImpl implements ReserveService{

    @Autowired
    ReserveDaO reserveDaO;

    @Override
    @Transactional
    public void reserve(Reserve reserve) {
        reserveDaO.reserve(reserve);
    }
}
