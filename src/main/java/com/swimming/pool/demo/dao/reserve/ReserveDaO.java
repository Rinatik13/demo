package com.swimming.pool.demo.dao.reserve;

import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.entity.Reserve;
import com.swimming.pool.demo.entity.TimeTable;

import java.util.List;

public interface ReserveDaO {
    public void reserve(Reserve reserve);

    public void cancel(Reserve reserve);

    public Reserve getReserve(Reserve reserve);

    public List<Reserve> getAll();

}
