package kr.co.seoulit.erp.logistic.sales.controller;

import kr.co.seoulit.erp.account.slip.to.SlipBean;
import kr.co.seoulit.erp.logistic.sales.entity.SalesPlan;
import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.SalesPlanTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;



@CrossOrigin("*")
@RestController
@RequestMapping("/logi/sales/*")
public class SalesPlanController {

	@Autowired
	private SalesServiceFacade salesSF;

	private ModelMap modelMap = new ModelMap();

	@RequestMapping("/searchSalesPlan")
	public ModelMap searchSalesPlanInfo(@RequestParam String startDate, @RequestParam String endDate,
										@RequestParam String salesPlanDate) {

		System.out.println(salesPlanDate);

		try {

			ArrayList<SalesPlanTO> salesPlanTOList = salesSF.getSalesPlanList(salesPlanDate, startDate, endDate);

			modelMap.put("gridRowJson", salesPlanTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}

		return modelMap;
	}

	@RequestMapping(value = "/batchSalesPlanListProcess", method = RequestMethod.POST)
	public void batchListProcess(@RequestBody SalesPlanTO params) {
		System.out.println(params);
		salesSF.batchSalesPlanListProcess(params);
	}

	@RequestMapping(value = "/Selectsalesplane", method = RequestMethod.GET)

	public ModelMap Selectsalesplane() {
		System.out.println("@@@@@????");
		ArrayList<SalesPlanTO> salesplaneList = null;

		try {

			salesplaneList = salesSF.getSalesPlan();
			System.out.println(salesplaneList);
			//         companyList=
			modelMap.put("gridRowJson", salesplaneList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "����");

		} catch (DataAccessException e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		System.out.println("나온다 " + modelMap);
		return modelMap;

	}

	@RequestMapping(value = "/Insertsalesplan", method = RequestMethod.POST)
	public ModelMap addsalesplan(@RequestBody SalesPlanTO params) {
		System.out.println("params.toString() = " + params);
		salesSF.batchSalesPlanListProcess(params);
		/*System.out.println("estimateDetailTO1.getEstimateAmount() = " + estimateDetailTO1.getEstimateAmount());

		try {
			HashMap<String, Object> resultList = salesSF.addNewEstimate(estimateDate, newEstimateInfo);
			modelMap.clear();
			modelMap.put("result", resultList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
			System.out.println("서엉공");
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}*/
		return modelMap;
	}

	@PostMapping(value = "/UpdateSalesplan")
	public ModelMap updatesalesplan(@RequestBody SalesPlanTO params) {
		System.out.println("params.toString() = " + params);
		salesSF.UpdateSalesPlanListProcess(params);

		return modelMap;
	}

	@GetMapping(value = "/jpasalesplan")
	public List<SalesPlan> findJPA() {
		List<SalesPlan> modelMap = salesSF.findSalesPlan();
		return modelMap;
	}



	@PostMapping(value = "/jpasalesplansave")
	public void  jpasalesplansave(@RequestBody SalesPlan salesPlan){
		salesSF.salesplansave(salesPlan);
	}

	@PostMapping(value ="/jpaupdatesalesplan")
	public  ModelMap jpaupdatesalesplan(@RequestBody SalesPlanTO salesPlan) {
		System.out.println("업데이트" + salesPlan);
		return modelMap;
	}

}

