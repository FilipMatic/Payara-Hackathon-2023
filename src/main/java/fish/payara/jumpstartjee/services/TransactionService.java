package fish.payara.jumpstartjee.services;

import fish.payara.jumpstartjee.entities.TransactionEntity;
import fish.payara.jumpstartjee.repositories.TransactionRepository;

import jakarta.inject.Inject;

import java.util.List;

public class TransactionService {

    @Inject TransactionRepository transactionRepository;

    public TransactionEntity getTransactionById(Long transactionId) {
        return transactionRepository.getTransactionById(transactionId);
    }

    public TransactionEntity postTransaction(TransactionEntity transactionEntity) {
        return transactionRepository.postTransaction(transactionEntity);
    }

    public void flagTransaction(Long transactionId) {
        var transaction = getTransactionById(transactionId);
        transactionRepository.flagTransaction(transaction);
    }		

    public List<TransactionEntity> getTransactionsByClientAccountIds(Long clientId, Long accountId) {
        return transactionRepository.getTransactionsByClientAccountIds(clientId, accountId);
    }
}
