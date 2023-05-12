package kr.co.seoulit.erp.logistic.production.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.production.dao.MpsDAO;
import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;
import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.production.to.SalesPlanInMpsAvailableTO;
import kr.co.seoulit.erp.logistic.sales.dao.ContractDetailDAO;
import kr.co.seoulit.erp.logistic.sales.dao.SalesPlanDAO;

@Component
public class MpsApplicationServiceImpl implements MpsApplicationService {

	@Autowired
	private MpsDAO mpsDAO;
	@Autowired
	private ContractDetailDAO contractDetailDAO;
	@Autowired
	private SalesPlanDAO salesPlanDAO;

	public ArrayList<MpsTO> getMpsList(String startDate, String endDate, String includeMrpApply) {

		HashMap<String, String> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("includeMrpApply", includeMrpApply);

		return mpsDAO.selectMpsList(param);
	}



	public ArrayList<SalesPlanInMpsAvailableTO> getSalesPlanListInMpsAvailable(String searchCondition, String startDate,
			String endDate) {

		HashMap<String, String> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("searchCondition", searchCondition);

		return salesPlanDAO.selectSalesPlanListInMpsAvailable(param);
	}



}
