package fish.payara.jumpstartjee.repositories;

import fish.payara.jumpstartjee.entities.TransactionEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@ApplicationScoped
public class TransactionRepository {

    @PersistenceContext
    private EntityManager em;

    public TransactionEntity getTransactionById(Long transactionId) {
      return em.find(TransactionEntity.class, transactionId);
    }

    public TransactionEntity postTransaction(TransactionEntity transactionEntity) {
      em.persist(transactionEntity);
      return transactionEntity;
    }

    public void flagTransaction(TransactionEntity transactionEntity) {
      em.remove(transactionEntity);
    }		

    public List<TransactionEntity> getTransactionsByClientAccountIds(Long clientId, Long accountId) {
      return em
          .createQuery("SELECT t FROM Transaction t JOIN Account a ON t.account_id = a.account_id WHERE (t.sender_account_id = :accountId OR t.receiver_account_id = :accountId) AND a.client_id = :clientId",
          TransactionEntity.class)
          .getResultList();
    }
  
}
