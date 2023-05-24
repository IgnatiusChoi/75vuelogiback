package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;


import kr.co.seoulit.erp.logistic.production.dao.WorkOrderDAO;
import kr.co.seoulit.erp.logistic.production.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.logistic.production.applicationservice.WorkOrderApplicationService;

import kr.co.seoulit.erp.logistic.production.to.ProductionPerformanceInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkOrderInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteSimulationTO;


@Service
public class ProductionServiceFacadeImpl implements ProductionServiceFacade {



	@Autowired
	private WorkOrderApplicationService workOrderAS;
	@Autowired
	private WorkOrderDAO workOrderDAO;


	@Override
	public HashMap<String, Object> getWorkOrderableMrpList() {

		return workOrderAS.getWorkOrderableMrpList();

	}

	@Override
	public HashMap<String, Object> getWorkOrderSimulationList(String mrpNo,String mrpGatheringNo) {

		return workOrderAS.getWorkOrderSimulationList(mrpNo,mrpGatheringNo);

	}

	@Override
	public HashMap<String, Object> workOrder(String mrpGatheringNo, String workPlaceCode, String productionProcess) {

		return workOrderAS.workOrder(mrpGatheringNo, workPlaceCode, productionProcess);

	}

	@Override
	public ArrayList<WorkOrderInfoTO> getWorkOrderInfoList() {

		return workOrderAS.getWorkOrderInfoList();

	}

	@Override
	public HashMap<String, Object> workOrderCompletion(String workOrderNo, String actualCompletionAmount) {

		return workOrderAS.workOrderCompletion(workOrderNo, actualCompletionAmount);

	}

	@Override
	public ArrayList<ProductionPerformanceInfoTO> getProductionPerformanceInfoList() {

		return workOrderAS.getProductionPerformanceInfoList();

	}

	@Override
	public HashMap<String, Object> showWorkSiteSituation(String workSiteCourse, String workOrderNo,
														 String itemClassIfication) {

		return workOrderAS.showWorkSiteSituation(workSiteCourse, workOrderNo, itemClassIfication);

	}

	@Override
	public void workCompletion(HashMap<String, ArrayList<WorkSiteSimulationTO>> workOrderInfo) {

		workOrderAS.workCompletion(workOrderInfo);

	}

	@Override
	public HashMap<String, Object> workSiteLogList(String workSiteLogDate) {

		return workOrderAS.workSiteLogList(workSiteLogDate);
	}

	@Override
	public ArrayList<WorkOrderInfoTO> getWorkOrderInfoListStatus() {
		return workOrderDAO.selectWorkOrderInfoListStatus();
	}


	@Override
	public ArrayList<WorkSiteLogTO> getProductionProcessCode(HashMap<String, String> map) {
		return workOrderDAO.selectProductionProcessCode(map);
	}


}
