package kr.co.seoulit.erp.logistic.base.controller;

import kr.co.seoulit.erp.logistic.base.servicefacade.CompanyServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;

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
public class InformationController {

    @Autowired
    private CompanyServiceFacade companySF;

    private ModelMap modelMap = new ModelMap();

    @RequestMapping(value = "/base/getcompanyInfo", method = RequestMethod.GET)
    public ModelMap getCompanyInfo(){
        try {
            ArrayList<CompanyInfoTO> companyInfo = companySF.getCompanyInfo();
            modelMap.put("companyInfo", companyInfo);
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
