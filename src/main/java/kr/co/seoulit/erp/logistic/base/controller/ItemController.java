package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.seoulit.erp.logistic.base.servicefacade.ItemServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.base.servicefacade.WarehouseServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;

@Api(description = "품목관리")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base/*")
public class ItemController {
	// 75기 3조 물류 최영현 수정
	// 주요 수정내용 : search조건 간략화 및 status를 이용한 batchlistprocess작업 일원화, applicationservice삭제, workplace와 중복 삭제

	@Autowired
	private ItemServiceFacade itemSF;
	@ApiOperation(value = "품목 조회")
	@RequestMapping(value = "/searchItemList", method = RequestMethod.GET)
	public ModelMap searchItemList(){
		return itemSF.searchItemList();
	}
	@ApiOperation(value = "품목군 조회")
	@RequestMapping(value = "/searchItemGroupList", method = RequestMethod.GET)
	public ModelMap searchItemGroupList(){
		return itemSF.searchItemGroupList();
	}
	@ApiOperation(value = "품목 추가,수정,삭제")
	@PostMapping("/itemBatchListProcess")
	public void batchListProcess(@RequestBody @ApiParam(value = "품목JSON")ItemTO batchList) {
		itemSF.batchListProcess(batchList);
	}
	@ApiOperation(value = "품목군 추가,수정,삭제")
	@PostMapping("/itemGroupBatchListProcess")
	public void itemGroupBatchListProcess(@RequestBody @ApiParam(value = "품목군JSON")ItemGroupTO batchList) {
		itemSF.itemGroupBatchListProcess(batchList);
	}
}
