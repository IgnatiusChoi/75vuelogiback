package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.domain.WorkSiteLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkSiteLogRepository extends JpaRepository<WorkSiteLog, Long> {
   List<WorkSiteLog> findByWorkSiteNameAndProductionProcessCode(String productionProcessCode, String workSiteName);
}
