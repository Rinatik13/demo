package com.swimming.pool.demo.service.reserve;

import com.swimming.pool.demo.dao.reserve.ReserveDaO;
import com.swimming.pool.demo.entity.Reserve;
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

    @Override
    @Transactional
    public void cancel(Reserve reserve) {
        reserveDaO.cancel(reserve);
    }

    @Override
    @Transactional
    public Reserve getReserve(Reserve reserve) {
        return reserveDaO.getReserve(reserve);
    }
}
