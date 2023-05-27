package kr.co.seoulit.erp.logistic.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.logistic.base.servicefacade.ItemServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.base.servicefacade.LogisticsInfoServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ItemInfoTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;

@SuppressWarnings("unused")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base/*")
public class ItemController {
	// 75기 3조 물류 최영현 수정
	// 주요 수정내용 : search조건 간략화 및 status를 이용한 batchlistprocess작업 일원화, applicationservice삭제는 충돌되는 사항이 있어 임시보류
	@Autowired
	private LogisticsInfoServiceFacade logisticsSF;
	@Autowired
	private ItemServiceFacade itemSF;

	private ModelMap modelMap = new ModelMap();

	@RequestMapping(value = "/searchItemList", method = RequestMethod.GET)
	public Map<String, Object> searchItemList(){
		Map<String, Object> result=itemSF.searchItemList();
		return result;
	}
	@RequestMapping(value = "/searchItemGroupList", method = RequestMethod.GET)
	public Map<String, Object> searchItemGroupList(){
		Map<String, Object> result=itemSF.searchItemGroupList();
		return result;
	}
	@PostMapping("/itemBatchListProcess")
	public Map<String, Object> batchListProcess(@RequestBody ItemTO batchList) {
		Map<String, Object> result=itemSF.batchListProcess(batchList);
		return result;
	}
	@PostMapping("/itemGroupBatchListProcess")
	public Map<String, Object> itemGroupBatchListProcess(@RequestBody ItemGroupTO batchList) {
		Map<String, Object> result=itemSF.itemGroupBatchListProcess(batchList);
		return result;
	}
}
