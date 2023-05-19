package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;

import java.util.HashMap;
import java.util.Map;

public interface MpsServiceFacade {

    public Map<String, Object> getContractDetailListInMpsAvailable(String searchCondition,
                                                                   String startDate,
                                                                   String endDate);

    public HashMap<String, Object> convertContractDetailToMps(
            ContractDetailInMpsAvailableTO contractDetailInMpsAvailableTO);

    public HashMap<String, Object> searchMpsList();

}
