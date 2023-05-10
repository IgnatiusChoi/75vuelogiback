package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.Map;

public interface MpsServiceFacade {

    public Map<String, Object> getContractDetailListInMpsAvailable(String searchCondition,
                                                                   String startDate,
                                                                   String endDate);

}
