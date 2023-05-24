package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.logistic.production.to.*;

public interface ProductionServiceFacade {



	public HashMap<String, Object> getWorkOrderableMrpList();

	public HashMap<String, Object> getWorkOrderSimulationList(String mrpNo,String mrpGatheringNo);

	public HashMap<String, Object> workOrder(String mrpGatheringNo, String workPlaceCode, String productionProcess);

	public ArrayList<WorkOrderInfoTO> getWorkOrderInfoList();

	public HashMap<String, Object> workOrderCompletion(String workOrderNo, String actualCompletionAmount);

	public ArrayList<ProductionPerformanceInfoTO> getProductionPerformanceInfoList();

	public HashMap<String, Object> showWorkSiteSituation(String workSiteCourse, String workOrderNo,
														 String itemClassIfication);

	public void workCompletion(HashMap<String, ArrayList<WorkSiteSimulationTO>> workOrderInfo);

	public HashMap<String, Object> workSiteLogList(String workSiteLogDate);

	public ArrayList<WorkOrderInfoTO> getWorkOrderInfoListStatus();

//	public HashMap<String, Object> getWorkOrderableInfoList();

	public ArrayList<WorkSiteLogTO> getProductionProcessCode(HashMap<String, String> map);

}
