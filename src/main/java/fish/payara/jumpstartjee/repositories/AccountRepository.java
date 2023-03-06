package fish.payara.jumpstartjee.repositories;

import fish.payara.jumpstartjee.entities.AccountEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@ApplicationScoped
public class AccountRepository {

		@PersistenceContext
		private EntityManager em;

		public AccountEntity getAccountById(Long accountId) {
				return em.find(AccountEntity.class, accountId);
		}
	
		public AccountEntity openAccount(AccountEntity accountEntity) {
				em.persist(accountEntity);
				return accountEntity;
		}

		public void closeAccount(AccountEntity accountEntity) {
				em.remove(accountEntity);
		}		

		public List<AccountEntity> getAccountsByClientId(Long clientId) {
			return em
					.createQuery("SELECT a.account_id FROM Account a WHERE a.client_id = :clientId",
							AccountEntity.class)
					.setParameter("clientId", clientId)
					.getResultList();
		}

		public BigDecimal getTotalsByClientId(Long clientId) {
			return em
					.createQuery("SELECT SUM(a.amount) FROM Account a WHERE a.client_id = :clientId",
							BigDecimal.class)
					.setParameter("clientId", clientId)
					.getSingleResult();
		}
		
}
