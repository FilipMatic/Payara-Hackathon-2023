package fish.payara.jumpstartjee.services;

import fish.payara.jumpstartjee.entities.ClientEntity;
import fish.payara.jumpstartjee.repositories.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClientService {
    @Inject private ClientRepository clientRepository;

    public ClientEntity getClientById(Long clientId) {
      return clientRepository.getClientById(clientId);
    }

    public ClientEntity persistClient(ClientEntity client) {
      return clientRepository.persistClient(client);
    }

    public void removeClient(Long clientId) {
      var client = getClientById(clientId);
      clientRepository.removeClient(client);
    }
}
