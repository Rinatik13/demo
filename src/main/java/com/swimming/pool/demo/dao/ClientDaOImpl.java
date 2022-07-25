package com.swimming.pool.demo.dao;

import com.swimming.pool.demo.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientDaOImpl implements ClientDaO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> allClient = session.createQuery("from Client",
                Client.class)
                .getResultList();
        return allClient;
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
    }
}
