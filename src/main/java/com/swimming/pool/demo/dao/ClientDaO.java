package com.swimming.pool.demo.dao;

import com.swimming.pool.demo.entity.Client;

import java.util.List;


public interface ClientDaO {
    public List<Client> getAllClients();

    public void saveClient(Client client);
}
