package kr.co.seoulit.erp.logistic.production.controller;

import kr.co.seoulit.erp.logistic.production.domain.WorkSite;
import kr.co.seoulit.erp.logistic.production.servicefacade.WorkSiteServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class WorkSiteController {

    @Autowired
    private WorkSiteServiceFacade workSiteSF;
//    private ModelMap modelMap = new ModelMap();

    @Autowired
    public WorkSiteController(WorkSiteServiceFacade workSiteSF) {
        this.workSiteSF = workSiteSF;
    }

//    @GetMapping("/getWorkSiteList")
//    public ModelMap getWorkPlaceList(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("getWorkSiteList");
//        ArrayList<WorkSiteTO> workPlaceList = null;
//
//        try {
//            workPlaceList = workSiteSF.getWorkSiteList();
//
//            modelMap.put("gridRowJson", workPlaceList);
//            modelMap.put("errorCode", 1);
//            modelMap.put("errorMsg", " 에러 ");
//
//        } catch (Exception e2) {
//            e2.printStackTrace();
//            modelMap.put("errorCode", -2);
//            modelMap.put("errorMsg", e2.getMessage());
//        }
//        return modelMap;
//    }

    /*********************************
     작업장/작업장 로그 = 작업장 조회(JPA)
     *********************************/
    @RequestMapping(value = "/getWorkSiteList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,List<WorkSite>>> getWorkSiteList() {
        System.out.println("WorkSiteContoller");
        Map<String,List<WorkSite>> map = new HashMap<>();
        List<WorkSite> workSiteList = workSiteSF.getWorkSiteList();

        if(workSiteList.isEmpty())
            return ResponseEntity.notFound().build();

        map.put("WorkSiteList",workSiteList);
        return ResponseEntity.ok(map);
    }




    //작업장/작업장 로그 = 작업장 로그 조회
//    @RequestMapping("/getProductionProcessCode")
//    public HashMap<String, Object> searchProductionProcessCode(@RequestParam String productionProcessCode,
//                                                               @RequestParam String workSiteCode) {
//        System.out.println("getProductionProcessCode");
//        System.out.println("productionProcessCode ========== " + productionProcessCode);
//        System.out.println("workSiteCode ============== " + workSiteCode);
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("productionProcessCode", productionProcessCode);
//        map.put("workSiteCode", workSiteCode);
//        ArrayList<WorkSiteLogTO> getProductionProcessCode = workSiteSF.getProductionProcessCode(map);
//
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("gridRowJson", getProductionProcessCode);
//        param.put("errorCode", 1);
//        param.put("errorMsg", "성공");
//
//        return param;
//    }





//    //작업장/작업장 로그 = 작업장 추가
//    @PostMapping(value = "/insertWorkPlaceList")
//    public HashMap<Object, Object> addWorkPlaceList(@RequestBody HashMap<Object, Object> paramList) {
//        System.out.println("paramList = " + paramList);
//        ObjectMapper mapper = new ObjectMapper();
//        WorkSiteLogTO newWorkPlaceList = mapper.convertValue(paramList, WorkSiteLogTO.class);
//
//        System.out.println("newWorkPlaceList");
//        System.out.println(newWorkPlaceList);
//
//        HashMap<Object, Object> map = new HashMap<>();
//        try {
//            workSiteSF.insertWorkPlaceList(newWorkPlaceList);
//            map.put("errorCode", 1);
//            map.put("errorMsg", "성공");
//            System.out.println("성공");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("errorCode", -2);
//            map.put("errorMsg", e.getMessage());
//        }
//        return map;
//    }
//
//
//    //작업장/작업장 로그 = 작업장 삭제
//    @PostMapping(value = "/deleteWorkPlaceList")
//    public HashMap<String, Object> deleteWorkPlaceList(@RequestBody WorkSiteLogTO workPlaceList) {
//        System.out.println("workPlaceList" + workPlaceList);
//
//        try {
//            workSiteSF.deleteWorkPlaceList(workPlaceList);
//            modelMap.put("errorCode", 1);
//            modelMap.put("errorMsg", "성공");
//            System.out.println("성공");
//        } catch (Exception e) {
//            e.printStackTrace();
//            modelMap.put("errorCode", -2);
//            modelMap.put("errorMsg", e.getMessage());
//        }
//        return modelMap;
//    }


}
