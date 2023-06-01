package kr.co.seoulit.erp.logistic.production.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.domain.SalesPlan;
import kr.co.seoulit.erp.logistic.production.domain.WorkOrderInfo;
import kr.co.seoulit.erp.logistic.production.servicefacade.ProductionPerformanceServiceFacade;
import kr.co.seoulit.erp.logistic.production.servicefacade.WorkOrderServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.production.to.ProductionPerformanceInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkOrderInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteSimulationTO;


@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class ProductionPerformanceController {

    @Autowired
    private ProductionPerformanceServiceFacade ProductionPerformanceSF;
    private ModelMap modelMap = new ModelMap();


    /*****************************
     생산실적관리 Tab - 생산실적관리조회(JPA)
     *****************************/
    @RequestMapping(value = "/getProductionPerformanceInfoList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductionPerformance>> getWorkOrderInfoListStatus() {
        System.out.println("ProductionPerformanceController = " );
        List<ProductionPerformance> ProductionPerformanceList = ProductionPerformanceSF.getProductionPerformanceInfoList();
        System.out.println("ProductionPerformanceController = " );
        return new ResponseEntity<>(ProductionPerformanceList, HttpStatus.OK);
    }

//    @RequestMapping(value = "/productionperformance/itemClassification", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<ProductionPerformance>> getItemClassifiction(@RequestParam String itemClassification) {
//        System.out.println("ProductionPerformanceController = " );
//        List<ProductionPerformance> ProductionPerformanceList = ProductionPerformanceSF.getItemClassifiction(itemClassification);
//        System.out.println("ProductionPerformanceController = " );
//        return new ResponseEntity<>(ProductionPerformanceList, HttpStatus.OK);
//    }


}
