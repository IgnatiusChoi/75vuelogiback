package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.dao.CompanyInfoDAO;
import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CompanyInfoApplicationServiceImpl implements CompanyInfoApplicationService {
    @Autowired
    private CompanyInfoDAO companyInfoDAO;
    public ArrayList<CompanyInfoTO> getCompanyInfo(){
        return companyInfoDAO.getCompanyInfo();
    }
}
