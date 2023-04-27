package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.applicationservice.CompanyInfoApplicationService;
import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyServiceFacadeImpl implements CompanyServiceFacade{
    @Autowired
    private CompanyInfoApplicationService CompanyAS;
    public ArrayList<CompanyInfoTO> getCompanyInfo(){
        ArrayList<CompanyInfoTO> companyInfo = CompanyAS.getCompanyInfo();
        return companyInfo;
    }
}
