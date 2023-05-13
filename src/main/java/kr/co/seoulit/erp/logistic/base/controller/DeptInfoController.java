package kr.co.seoulit.erp.logistic.base.controller;

import kr.co.seoulit.erp.logistic.base.servicefacade.DeptInfoServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.DeptInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
@RequestMapping("/logi/*")
public class DeptInfoController {

    @Autowired
    private DeptInfoServiceFacade deptSF;

    private ModelMap modelMap = new ModelMap();

    @RequestMapping(value = "/base/getdeptInfo", method = RequestMethod.GET)
    public ModelMap getDeptInfo() {
        try {
            ArrayList<DeptInfoTO> deptInfo = deptSF.getDeptInfo();
            modelMap.put("deptInfo", deptInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());
        }
        return modelMap;
    }

}
