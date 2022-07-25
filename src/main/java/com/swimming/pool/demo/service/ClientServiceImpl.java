package com.swimming.pool.demo.service;

import com.swimming.pool.demo.dao.ClientDaO;
import com.swimming.pool.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientDaO clientDaO;

    @Override
    @Transactional
    public List<Client> getAllClients() {
        return clientDaO.getAllClients();
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDaO.saveClient(client);
    }
}
