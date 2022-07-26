package com.swimming.pool.demo.dao.reserve;

import com.swimming.pool.demo.entity.Reserve;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDaOImpl implements ReserveDaO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void reserve(Reserve reserve) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(reserve);
    }
}
