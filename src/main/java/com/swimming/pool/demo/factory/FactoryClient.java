package com.swimming.pool.demo.factory;

import com.swimming.pool.demo.entity.Client;

// создаём нового клиента
public class FactoryClient {
    public static Client create(String name, String phone, String email){
        Client client = new Client();
        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);
        return client;
    }
}
