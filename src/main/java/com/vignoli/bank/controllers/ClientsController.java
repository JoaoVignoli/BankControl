package com.vignoli.bank.controllers;

import com.vignoli.bank.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    private final ArrayList<Client> clients = new ArrayList<>();

    public ClientsController() {
        Client client1 = new Client(1, "João Victor Vignoli", "12345678987");
        Client client2 = new Client(2, "Rodolfo Pereira", "78945612354");

        clients.add(client1);
        clients.add(client2);
    }

    @GetMapping
    public List<Client> getClients() {
        return clients;
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable Integer clientId) {
        for (Client client: clients) {
            if (Objects.equals(client.getId(), clientId)) {
                return client;
            }
        }
        return null;
    }

}
