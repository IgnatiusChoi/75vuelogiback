package kr.co.seoulit.erp.logistic.production.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.logistic.production.servicefacade.MpsServiceFacade;
import kr.co.seoulit.erp.sys.to.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import kr.co.seoulit.erp.logistic.production.servicefacade.ProductionServiceFacade;
import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;
import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import kr.co.seoulit.erp.logistic.production.to.SalesPlanInMpsAvailableTO;

import static kr.co.seoulit.erp.sys.to.response.Response.success;

@SuppressWarnings("unused")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class MpsController {

	/**
	 *
	 * 23.5.10. ~ 1차 프로젝트
	 * MPS/MRP 분리, 필드 주입 대신 생성자 주입
	 * HttpServlet 제거, 스파게티 소스 의존성 제거, Controller에서의 비즈니스 로직 제거, ApplicationService 제거
	 * JSON Type 응답, MPS 비즈니스 로직에서 Contract 테이블 변경하던 것 수정
	 *
	 */

	private final ProductionServiceFacade productionSF;
	private final MpsServiceFacade mpsSF;
	private final ModelMap modelMap = new ModelMap();

	@Autowired
	public MpsController(ProductionServiceFacade productionSF, MpsServiceFacade mpsSF) {
		this.productionSF = productionSF;
		this.mpsSF = mpsSF;
	}


	@RequestMapping("/searchMpsInfo")
	public Response searchMpsInfo(HttpServletRequest request, HttpServletResponse response) {

		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String includeMrpApply = request.getParameter("includeMrpApply");
		System.out.println("넘어온 시작날짜::::::::" + startDate);
		System.out.println("넘어온 종료날짜::::::::" + endDate);
		System.out.println("넘어온 ???::::::::" + includeMrpApply);

		try {

			ArrayList<MpsTO> mpsTOList = productionSF.getMpsList(startDate, endDate, includeMrpApply);

			modelMap.put("gridRowJson", mpsTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "�꽦怨�");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return success(modelMap);
	}

	@RequestMapping("/searchContractDetailInMpsAvailable")
	@ResponseBody
	public Map<String, Object> searchContractDetailListInMpsAvailable(@RequestParam String startDate,
																	  @RequestParam String endDate,
																	  @RequestParam String searchCondition) {

		Map<String, Object> result = mpsSF.getContractDetailListInMpsAvailable(searchCondition, startDate, endDate);

		return result;
	}

	@RequestMapping(value = "/convertContractDetailToMps", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> convertContractDetailToMps(@RequestBody ContractDetailInMpsAvailableTO contract) {

			HashMap<String, Object> resultMap = mpsSF.convertContractDetailToMps(contract);
			return resultMap;
	}

	@RequestMapping(value = "/searchMpsList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> searchMpsList() {

		HashMap<String, Object> resultMap = mpsSF.searchMpsList();
		return resultMap;
	}

}


		/**
		 * 판매계획 별 MPS 등록은 구현 x
 		 **/

//	@RequestMapping("/convertSalesPlanToMps")
//	public ModelMap convertSalesPlanToMps(HttpServletRequest request, HttpServletResponse response) {

//		String batchList = request.getParameter("batchList");

//		ArrayList<SalesPlanInMpsAvailableTO> salesPlanInMpsAvailableList = gson.fromJson(batchList,
//				new TypeToken<ArrayList<SalesPlanInMpsAvailableTO>>() {
//				}.getType());
//
//		try {

//			HashMap<String, Object> resultMap = productionSF.convertSalesPlanToMps(salesPlanInMpsAvailableList);
//
//			modelMap.put("result", resultMap);
//			modelMap.put("errorCode", 1);
//			modelMap.put("errorMsg", "�꽦怨�");
//
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			modelMap.put("errorCode", -2);
//			modelMap.put("errorMsg", e2.getMessage());
//
//		}
//		return modelMap;
//	}
//
//}



//	@RequestMapping("/searchSalesPlanInMpsAvailable")
//	public ModelMap searchSalesPlanListInMpsAvailable(HttpServletRequest request, HttpServletResponse response) {
//
//		String searchCondition = request.getParameter("searchCondition");
//		String startDate = request.getParameter("startDate");
//		String endDate = request.getParameter("endDate");
//
//		try {
//
//			ArrayList<SalesPlanInMpsAvailableTO> salesPlanInMpsAvailableList = productionSF
//					.getSalesPlanListInMpsAvailable(searchCondition, startDate, endDate);
//
//			modelMap.put("gridRowJson", salesPlanInMpsAvailableList);
//			modelMap.put("errorCode", 1);
//			modelMap.put("errorMsg", "�꽦怨�");
//
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			modelMap.put("errorCode", -2);
//			modelMap.put("errorMsg", e2.getMessage());
//
//		}
//		return modelMap;

