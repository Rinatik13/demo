package com.swimming.pool.demo.service.reserve;

import com.swimming.pool.demo.entity.Reserve;

import java.util.List;

public interface ReserveService {
    public Reserve reserve(Reserve reserve);

    public void cancel(Reserve reserve);

    public Reserve getReserve(Reserve reserve);

    public List<Reserve> getAll();

    public void create();
}
