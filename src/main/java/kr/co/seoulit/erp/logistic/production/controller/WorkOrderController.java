package kr.co.seoulit.erp.logistic.production.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.logistic.production.servicefacade.WorkOrderServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.production.to.ProductionPerformanceInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkOrderInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteSimulationTO;


@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class WorkOrderController {

	@Autowired
	private WorkOrderServiceFacade workOrderSF;
	private ProductionServiceFacade productionSF;
	private ModelMap modelMap = new ModelMap();


	//작업지시 Tab -  작업지시 필요항목 조회
	@RequestMapping("/getWorkOrderableMrpList")
	public HashMap<String, Object> getWorkOrderableMrpList(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> resultMap = new HashMap<>();

		try {
			resultMap = workOrderSF.getWorkOrderableMrpList();
			System.out.println("resultMap.toString() = " + resultMap.toString());
		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());
		}
		return resultMap;
	}

	//작업지시 Tab -  작업지시 모의전개
	@RequestMapping("/showWorkOrderDialog")
	public HashMap<String, Object> showWorkOrderDialog(@RequestParam String mrpNo, @RequestParam String mrpGatheringNo) {
		HashMap<String, Object> resultMap = new HashMap<>();

		System.out.println("mrpGatheringNo :" + mrpGatheringNo + "mrpNo: " + mrpNo);

		try {
			resultMap = workOrderSF.getWorkOrderSimulationList(mrpNo, mrpGatheringNo);

		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}
		return resultMap;
	}

	//작업지시 Tab - 작업지시 모의전개 버튼 누른 후 - 실제 작업 지시 버튼
	@RequestMapping("/workOrder")
	public HashMap<String, Object> workOrder(HttpServletRequest request, HttpServletResponse response) {

		String mrpGatheringNo = request.getParameter("mrpGatheringNo");
		String workPlaceCode = request.getParameter("workPlaceCode");
		String productionProcess = request.getParameter("productionProcessCode");
		System.out.println(productionProcess);
		HashMap<String, Object> resultMap = new HashMap<>();

		try {

			resultMap = workOrderSF.workOrder(mrpGatheringNo, workPlaceCode, productionProcess);

		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}
		return resultMap;
	}

	//작업지시현황 Tab - 작업지시현황조회
	@GetMapping("/getWorkOrderInfoListStatus")
	public ModelMap getWorkOrderInfoListStatus(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("getWorkOrderInfoList");
		ArrayList<WorkOrderInfoTO> getWorkOrderInfoListStatus = null;

		try {
			getWorkOrderInfoListStatus = workOrderSF.getWorkOrderInfoListStatus();

			modelMap.put("gridRowJson", getWorkOrderInfoListStatus);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", " 꽦怨 ");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}
		return modelMap;
	}

	@PutMapping("/editCellBlur")
	public int editCellBlur(@RequestBody WorkOrderInfoTO workOrderInfoTO) {

		System.out.println("workOrderInfoTO = " + workOrderInfoTO);
		int count=0;
		try {
			count = workOrderSF.editCellBlur(workOrderInfoTO.getWorkOrderNo(), workOrderInfoTO.getActualCompletionAmount());

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}
		return count;
	}




	//작업지시현황 Tab - 작업완료등록
	@RequestMapping("/workOrderCompletion")
	public HashMap<String, Object> workOrderCompletion(@RequestParam String workOrderNo, @RequestParam String actualCompletionAmount) {

		HashMap<String, Object> resultMap = new HashMap<>();

		try {
			resultMap = workOrderSF.workOrderCompletion(workOrderNo, actualCompletionAmount);
		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());
		}
		return resultMap;
	}

	//생산실적관리 Tab - 생산실적관리조회
	@RequestMapping("/getProductionPerformanceInfoList")
	public ModelMap getProductionPerformanceInfoList(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<ProductionPerformanceInfoTO> productionPerformanceInfoList = null;

		try {
			productionPerformanceInfoList = workOrderSF.getProductionPerformanceInfoList();

			modelMap.put("gridRowJson", productionPerformanceInfoList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", " 꽦怨 ");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}






























	@RequestMapping("/showWorkOrderInfoList")
	public ModelMap showWorkOrderInfoList(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<WorkOrderInfoTO> workOrderInfoList = null;

		try {

			workOrderInfoList = workOrderSF.getWorkOrderInfoList();

			modelMap.put("gridRowJson", workOrderInfoList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", " 꽦怨 ");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}






	@RequestMapping("/showWorkSiteSituation")
	public HashMap<String, Object> showWorkSiteSituation(HttpServletRequest request, HttpServletResponse response) {

		HashMap<String, Object> resultMap = new HashMap<>();

		String workSiteCourse = request.getParameter("workSiteCourse");
		String workOrderNo = request.getParameter("workOrderNo");
		String itemClassIfication = request.getParameter("itemClassIfication");

		try {

			resultMap = workOrderSF.showWorkSiteSituation(workSiteCourse, workOrderNo, itemClassIfication);

			resultMap.put("gridRowJson", resultMap.get("result"));
			resultMap.put("errorCode", resultMap.get("errorCode"));
			resultMap.put("errorMsg", resultMap.get("errorMsg"));

			System.out.println("@@@@@");
			System.out.println(resultMap);
			System.out.println(resultMap.get("result"));
		} catch (Exception e2) {
			e2.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", e2.getMessage());

		}
		return resultMap;
	}


	@RequestMapping("/workCompletion")
	public ModelMap workCompletion(@RequestBody HashMap<String, ArrayList<WorkSiteSimulationTO>> workOrderInfo) {

//      ArrayList<String> itemCodeListArr = gson.fromJson(itemCodeList,
//            new TypeToken<ArrayList<String>>() {}.getType());
		System.out.println("@@@@" + workOrderInfo);
//      System.out.println(workOrderNo);
//      System.out.println(itemCode);s
		try {

			workOrderSF.workCompletion(workOrderInfo);

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}


//	@RequestMapping("/getWorkOrderableInfoList")
//	public HashMap<String, Object> workSiteLogList() {
//
//		String workSiteLogDate = request.getParameter("workSiteLogDate");
//
//		System.out.println(workSiteLogDate);
//		HashMap<String, Object> resultMap = new HashMap<>();
//
//		try {
//
//			resultMap = productionSF.workSiteLogList(workSiteLogDate);
//
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			resultMap.put("errorCode", -2);
//			resultMap.put("errorMsg", e2.getMessage());
//
//		}
//		return resultMap;
//	}
}





