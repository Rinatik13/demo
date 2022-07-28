package com.swimming.pool.demo.service.client;

import com.swimming.pool.demo.dao.client.ClientDaO;
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
        List<Client> clientList = clientDaO.getAllClients();
        return clientList;
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDaO.saveClient(client);
    }

    @Override
    @Transactional
    public Client getClient(int id) {
        return clientDaO.getClient(id);
    }

    @Override
    @Transactional
    public void deleteClient(int id) {
        clientDaO.delete(id);
    }
}
