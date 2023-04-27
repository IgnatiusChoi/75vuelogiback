package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;

import java.util.ArrayList;

public interface CompanyServiceFacade {

    public ArrayList<CompanyInfoTO> getCompanyInfo();
}
