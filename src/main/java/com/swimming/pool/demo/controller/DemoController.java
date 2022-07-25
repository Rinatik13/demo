package com.swimming.pool.demo.controller;

import com.swimming.pool.demo.entity.Client;
import com.swimming.pool.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private ClientService clientService;

    // получаем список всех клиентов
    @RequestMapping("/")
    public String showAllClient(Model model){

        List<Client> clientList = clientService.getAllClients();
        model.addAttribute("allClient", clientList);

        return "showAllClient";
    }

    // добавляем нового клиента
    @RequestMapping("/addClient")
    public String addNewClient(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "newClient";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);

        return "redirect:/";
    }

}
