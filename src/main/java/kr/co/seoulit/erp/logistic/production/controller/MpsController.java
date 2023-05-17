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
	 * 75기 23.5.10. ~  1차 프로젝트
	 * MPS/MRP 분리, 필드 주입 대신 생성자 주입
	 * HttpServlet 제거, 스파게티 소스 의존성 제거, Controller에서의 비즈니스 로직 제거, ApplicationService 제거
	 * JSON Type 응답, salesPlan으로 조회 로직 제거(판매계획은 향후 구현 필요)
	 *
	 */

	private final MpsServiceFacade mpsSF;
	private final ModelMap modelMap = new ModelMap();

	@Autowired
	public MpsController(MpsServiceFacade mpsSF) {
		this.mpsSF = mpsSF;
	}



	/*****************************
		 MPS 등록가능 수주 조회
	 *****************************/
	@RequestMapping("/searchContractDetailInMpsAvailable")
	@ResponseBody
	public Map<String, Object> searchContractDetailListInMpsAvailable(@RequestParam String startDate,
																	  @RequestParam String endDate,
																	  @RequestParam String searchCondition) {
		Map<String, Object> result = mpsSF.getContractDetailListInMpsAvailable(searchCondition, startDate, endDate);

		return result;
	}

	/*****************************
			    MPS 등록
	 *****************************/
	@RequestMapping(value = "/convertContractDetailToMps", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> convertContractDetailToMps(@RequestBody ContractDetailInMpsAvailableTO contract) {

			HashMap<String, Object> resultMap = mpsSF.convertContractDetailToMps(contract);

			return resultMap;
	}

	/*****************************
	     차트용 MPS 테이블 조회
	 *****************************/
	@RequestMapping(value = "/searchMpsList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> searchMpsList() {
		HashMap<String, Object> resultMap = mpsSF.searchMpsList();
		return resultMap;
	}


	/**
	 *  판매계획......??
	 */




	/**
	 *  ★ MPS 수립 로직 작성 ★
	 *  MPS : 견적(수주)량 - 재고사용량 - 안전재고량 = (부족분)추가 생산
	 *	!이때 손실율은 제외하고 계산하기로 함
	 *
	 *  완제품(IT-CI)의 경우 : 추가 생산량 x 리드타임 = ? x 1일(DK-01기준)
	 *
	 *  반제품(IT-SI)의 경우 : DK-01 기준
	 *
	 *  DK-01	DK-AP01	2일
	 *  DK-01	DK-BC01	1일
	 *  DK-01	DK-FC01	1일
	 *  DK-01	MM-01	2일
	 *
	 *  원재료(IT-MA)의 경우 : DK-AP01 기준
	 *
	 *  DK-AP01	MC-KP01 5일
	 *  DK-AP01	LN-01 	2일
	 *  DK-AP01	JL-01 	2일
	 *  DK-AP01	HA-01 	2일
    **/


}

