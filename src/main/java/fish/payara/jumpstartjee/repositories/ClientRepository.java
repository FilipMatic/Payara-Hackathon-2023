package fish.payara.jumpstartjee.repositories;

import fish.payara.jumpstartjee.entities.ClientEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ClientRepository {
		@PersistenceContext
		private EntityManager em;

		public ClientEntity getClientById(Long clientId) {
			return em.find(ClientEntity.class, clientId);
		}
	
		public ClientEntity persistClient(ClientEntity clientEntity) {
			em.persist(clientEntity);
			return clientEntity;
		}

		public void removeClient(ClientEntity clientEntity) {
			em.remove(clientEntity);
	}	
}
