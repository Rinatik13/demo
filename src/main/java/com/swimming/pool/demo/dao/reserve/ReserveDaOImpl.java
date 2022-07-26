package com.swimming.pool.demo.dao.reserve;

import com.swimming.pool.demo.entity.Reserve;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReserveDaOImpl implements ReserveDaO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void reserve(Reserve reserve) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(reserve);
    }

    @Override
    public void cancel(Reserve reserve) {
        Session session = sessionFactory.getCurrentSession();
        Query<Reserve> query = session.createQuery("delete from Reserve " +
                "where id=:reserveId");
        query.setParameter("reserveId",reserve.getOrderId());
        query.executeUpdate();

    }

    @Override
    public Reserve getReserve(Reserve reserve) {
        Session session = sessionFactory.getCurrentSession();
        List<Reserve> reserveList = session.createQuery("from Reserve",
                Reserve.class).getResultList();
        for (Reserve r:reserveList){
            if (r.getOrderId().equals(reserve.getOrderId())){
                return r;
            }
        }
        return null;
    }
}
