package fish.payara.jumpstartjee.services;

import fish.payara.jumpstartjee.entities.LoanEntity;
import fish.payara.jumpstartjee.repositories.LoanRepository;

import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

public class LoanService {

    @Inject LoanRepository loanRepository;

    public LoanEntity getLoanById(Long loanId) {
        return loanRepository.getLoanById(loanId);
    }

    public LoanEntity postLoan(LoanEntity loanEntity) {
        return loanRepository.postLoan(loanEntity);
    }

    public LoanEntity updateLoanAmount(Long loanId, BigDecimal amount) {
        return loanRepository.updateLoanAmount(loanId, amount);
    }		

    public void closeLoan(Long loanId) {
        var loan = getLoanById(loanId);
        loanRepository.closeLoan(loan);
    }

    public List<LoanEntity> getLoansByClientId(Long clientId) {
      return loanRepository.getLoansByClientId(clientId);
  }
  
}
