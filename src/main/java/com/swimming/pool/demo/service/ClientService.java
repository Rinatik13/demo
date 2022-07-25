package com.swimming.pool.demo.service;

import com.swimming.pool.demo.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClients();

    public void saveClient(Client client);
}
