package fish.payara.jumpstartjee.services;

import fish.payara.jumpstartjee.entities.AccountEntity;
import fish.payara.jumpstartjee.repositories.AccountRepository;

import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

public class AccountService {

    @Inject AccountRepository accountRepository;

    public AccountEntity getAccountById(Long accountId) {
      return accountRepository.getAccountById(accountId);
    }

    public AccountEntity openAccount(AccountEntity accountEntity) {
      return accountRepository.openAccount(accountEntity);
    }

    public void closeAccountById(Long accountId) {
      var account = accountRepository.getAccountById(accountId);
      accountRepository.closeAccount(account);
    }		

    public List<AccountEntity> getAccountsByClientId(Long clientId) {
      return accountRepository.getAccountsByClientId(clientId);
    }

    public BigDecimal getTotalsByClientId(Long clientId) {
      return accountRepository.getTotalsByClientId(clientId);
    }
}
