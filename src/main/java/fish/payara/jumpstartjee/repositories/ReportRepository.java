package fish.payara.jumpstartjee.repositories;

import fish.payara.jumpstartjee.entities.ReportEntity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@ApplicationScoped
public class ReportRepository {

    @PersistenceContext
    private EntityManager em;

    public ReportEntity geReportById(Long reportId) {
        return em.find(ReportEntity.class, reportId);
    }

    public ReportEntity geReportByAccountIdDate(Long accountId, LocalDate date) {
        return em
            .createQuery(String.format("SELECT r FROM Report r WHERE r.account_id = :account_id AND MONTH(r.date) = MONTH(:accountId)"),
            ReportEntity.class)
            .setParameter("date", date)
            .setParameter("accountId", accountId)
            .getSingleResult();
    }

    public ReportEntity postReport(ReportEntity report) {
        // UPDATE LOGIC
        em.persist(report);
        return report;
    }

    public void deleteReport(ReportEntity report) {
        em.remove(report);
    }		

    public List<ReportEntity> getReportsByClientAccountIds(Long clientId, Long accountId) {
        return em
            .createQuery("SELECT r FROM Report r JOIN Account a ON r.account_id = a.account_id WHERE r.account_id = :accountId AND a.client_id = :clientId",
            ReportEntity.class)
            .setParameter("clientId", clientId)
            .setParameter("accountId", accountId)
            .getResultList();
    }
  
}
