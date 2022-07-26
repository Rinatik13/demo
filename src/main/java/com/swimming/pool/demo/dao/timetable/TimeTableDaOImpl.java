package com.swimming.pool.demo.dao.timetable;

import com.swimming.pool.demo.entity.TimeTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeTableDaOImpl implements TimeTableDaO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TimeTable> getAllDateReg() {
        Session session = sessionFactory.getCurrentSession();
        List<TimeTable> allDateReg = session.createQuery("from TimeTable",
                TimeTable.class)
                .getResultList();
        return allDateReg;
    }

    @Override
    public void saveDateReg(TimeTable dateReg) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(dateReg);
    }

    @Override
    public TimeTable getDateReg(int id) {
        Session session = sessionFactory.getCurrentSession();
        TimeTable dateReg = session.get(TimeTable.class, id);
        return dateReg;
    }

    @Override
    public void delete(int id) {
    Session session = sessionFactory.getCurrentSession();
        Query<TimeTable> query = session.createQuery("delete from TimeTable "+
                "where id=:dateRegId");
        query.setParameter("dateRegId", id);
        query.executeUpdate();

    }

    @Override
    public TimeTable getTime(String string) {
        Session session = sessionFactory.getCurrentSession();
        List<TimeTable> allDateReg = session.createQuery("from TimeTable",
                        TimeTable.class)
                .getResultList();
        for (TimeTable t:allDateReg){
            if (t.getTime().equals(string)){
                return t;
            }
        }
        return null;
    }
}
