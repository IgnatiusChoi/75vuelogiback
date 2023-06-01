package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.domain.WorkSiteLog;

import java.util.List;

public interface WorkSiteLogServiceFacade {

    public List<WorkSiteLog> getWorkSiteLog(String productionProcessCode, String workSiteName);
}
