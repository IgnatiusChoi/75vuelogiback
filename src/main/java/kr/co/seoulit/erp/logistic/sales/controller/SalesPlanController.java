package kr.co.seoulit.erp.logistic.sales.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import kr.co.seoulit.erp.hr.company.to.CompanyTO;
import kr.co.seoulit.erp.logistic.sales.to.EstimateDetailTO;
import kr.co.seoulit.erp.logistic.sales.to.EstimateTO;
import kr.co.seoulit.erp.logistic.sales.to.logisticExelTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.SalesPlanTO;

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


}


