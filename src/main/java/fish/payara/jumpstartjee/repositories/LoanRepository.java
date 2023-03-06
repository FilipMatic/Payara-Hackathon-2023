package fish.payara.jumpstartjee.repositories;

import fish.payara.jumpstartjee.entities.LoanEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@ApplicationScoped
public class LoanRepository {

    @PersistenceContext
		private EntityManager em;

		public LoanEntity getLoanById(Long loanId) {
				return em.find(LoanEntity.class, loanId);
		}
	
		public LoanEntity postLoan(LoanEntity loanEntity) {
				em.persist(loanEntity);
				return loanEntity;
		}

		public LoanEntity updateLoanAmount(Long accountId, BigDecimal amount) {
				return em
						.createQuery(String.format("UPDATE Loan l SET l.amount = :amount WHERE a.account_id = :accountId"),
								LoanEntity.class)
						.setParameter("accountId", accountId)
						.setParameter("amount", amount)
						.getSingleResult();
		}		

		public void closeLoan(LoanEntity loanEntity) {
				em.remove(loanEntity);;
		}

		public List<LoanEntity> getLoansByClientId(Long clientId) {
				return em
						.createQuery(String.format("SELECT l from Loan l WHERE l.client_id = :clientId"),
								LoanEntity.class)
						.setParameter("clientId", clientId)
						.getResultList();
		}
  
}
