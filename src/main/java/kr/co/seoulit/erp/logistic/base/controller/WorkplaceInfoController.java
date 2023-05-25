package kr.co.seoulit.erp.logistic.base.controller;

import kr.co.seoulit.erp.logistic.base.servicefacade.LogiBaseServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.WorkplaceInfoTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@SuppressWarnings("unused")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base/*")
public class WorkplaceInfoController {

    @Autowired
    private LogiBaseServiceFacade logiBaseServiceFacade;
    private ModelMap modelMap;

    @ResponseBody
    @RequestMapping(value = "/workplaceInfo", method = RequestMethod.GET)
    public ModelMap getWorkplaceInfo(@RequestParam String workplaceCode) {
        ArrayList<WorkplaceInfoTO> workplaceDetailList = logiBaseServiceFacade.getWorkplaceDetailList(workplaceCode);

        modelMap = new ModelMap();
        modelMap.put("workplaceInfo", workplaceDetailList);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/workplaceList", method = RequestMethod.GET)
    public ModelMap getWorkplaceList() {
        ArrayList<WorkplaceInfoTO> workplaceList = logiBaseServiceFacade.getWorkplaceList();
        modelMap = new ModelMap();
        modelMap.put("workplaceList", workplaceList);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/workplace", method = RequestMethod.POST)
    public void insertWorkplaceCode(@RequestBody WorkplaceInfoTO workplaceInfoTO) {
        logiBaseServiceFacade.insertWorkplaceCode(workplaceInfoTO);
    }

    @ResponseBody
    @RequestMapping(value = "/workplaceCode", method = RequestMethod.DELETE)
    public void deleteWorkplaceCode(@RequestParam String workplaceCode) {
        logiBaseServiceFacade.deleteWorkplaceCode(workplaceCode);
    }

    @ResponseBody
    @RequestMapping(value = "/workplaceupdate", method = RequestMethod.POST)
    public void updateWorkplaceCode(@RequestBody WorkplaceInfoTO workplaceInfoTO) {
        logiBaseServiceFacade.updateWorkplaceCode(workplaceInfoTO);
    }

}

