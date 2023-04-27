package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;

import java.util.ArrayList;

public interface CompanyInfoApplicationService {
    public ArrayList<CompanyInfoTO> getCompanyInfo();
}
