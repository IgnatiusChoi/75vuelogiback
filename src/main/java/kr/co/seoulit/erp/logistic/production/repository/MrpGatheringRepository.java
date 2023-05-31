package kr.co.seoulit.erp.logistic.production.repository;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.seoulit.erp.logistic.production.domain.MrpGathering;
import kr.co.seoulit.erp.logistic.production.domain.QMrpGathering;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MrpGatheringRepository {

    private final EntityManager em;
    public MrpGatheringRepository(EntityManager em) {
        this.em = em;
    }
    public List<MrpGathering> searchMrpGatheringList(String dateSearchCondition,
                                                     String startDate,
                                                     String endDate) {

        String query = "SELECT m FROM MrpGathering m " +
                "WHERE (CASE :dateSearchCondition " +
                "WHEN 'claimDate' THEN TO_DATE(m.claimDate, 'YYYY-MM-DD') " +
                "WHEN 'dueDate' THEN TO_DATE(m.dueDate, 'YYYY-MM-DD') " +
                "END) BETWEEN TO_DATE(:startDate, 'YYYY-MM-DD') AND TO_DATE(:endDate, 'YYYY-MM-DD')";

        return em.createQuery(query, MrpGathering.class)
                .setParameter("dateSearchCondition", dateSearchCondition)
                .setParameter("startDate", startDate.toString())
                .setParameter("endDate", endDate.toString())
                .getResultList();
    }
}
