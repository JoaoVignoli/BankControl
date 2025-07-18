package com.vignoli.bank.controllers;

import com.vignoli.bank.models.Client;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Object getClient(@PathVariable Integer clientId) {
        for (Client client: clients) {
            if (Objects.equals(client.getId(), clientId)) {
                return client;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public Client createClient(@RequestBody Client clientBody) {
        clientBody.setId(clients.getLast().getId() + 1);
        clients.add(clientBody);
        return clientBody;
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer clientId) {
        for (Client client: clients) {
            if (Objects.equals(client.getId(), clientId)) {
                clients.remove(client);
                return ResponseEntity.status(204).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{clientId}")
    public Object updateClient(@PathVariable Integer clientId, @RequestBody Client body) {
        for (Client client: clients) {
            if (Objects.equals(client.getId(), clientId)) {
                client.setName(body.getName());
                client.setTaxId(body.getTaxId());
                return client;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
