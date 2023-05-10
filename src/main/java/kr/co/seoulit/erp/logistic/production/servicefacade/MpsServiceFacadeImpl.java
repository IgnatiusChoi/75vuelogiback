package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.dao.MpsDAO;
import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Map;

@Service
public class MpsServiceFacadeImpl implements MpsServiceFacade{



    private final MpsDAO mpsDAO;
    private final ModelMap modelMap;

    @Autowired
    public MpsServiceFacadeImpl(MpsDAO mpsDAO) {
        this.mpsDAO = mpsDAO;
        this.modelMap = new ModelMap();
    }

    @Override
    public Map<String, Object> getContractDetailListInMpsAvailable(String searchCondition, String startDate, String endDate) {

        ArrayList<ContractDetailInMpsAvailableTO> resultList
                = mpsDAO.selectContractDetailListInMpsAvailable(searchCondition, startDate, endDate);

        try {
            modelMap.put("gridRowJson", resultList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "실패!");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());
        }

        return modelMap;
    }

}
