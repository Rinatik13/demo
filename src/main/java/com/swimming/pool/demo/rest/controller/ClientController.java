package com.swimming.pool.demo.rest.controller;

import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.exception_handing.ClientIncorrectData;
import com.swimming.pool.demo.exception_handing.NoSuchClientException;
import com.swimming.pool.demo.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/pool/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> showAllClient(){
        return clientService.getAllClients();

    }

    @GetMapping("/get/{id}")
    public Client getclient(@PathVariable int id){
        Client client = clientService.getClient(id);
        if (client==null){
            throw new NoSuchClientException("There is no client with ID = " +
                    id + " int Database");
        }
        return client;
    }

    @PostMapping("/add")
    public Client addClient (@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }

    @PostMapping("/update")
    public Client updateClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }

    @RequestMapping("/create")
    public void create(){
        Client client = new Client();

    }

    @ExceptionHandler
    public ResponseEntity<ClientIncorrectData> handleException(
            NoSuchClientException exception){
    ClientIncorrectData data = new ClientIncorrectData();
    data.setInfo(exception.getMessage());
    return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

}
