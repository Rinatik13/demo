package com.swimming.pool.demo.dao.client;

import com.swimming.pool.demo.entity.Client;

import java.util.List;


public interface ClientDaO {
    public List<Client> getAllClients();

    public void saveClient(Client client);

    public Client getClient(int id);

    public void delete(int id);

}
