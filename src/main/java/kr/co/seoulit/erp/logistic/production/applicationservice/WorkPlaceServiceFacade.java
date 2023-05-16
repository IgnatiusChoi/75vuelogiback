package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;

import java.util.ArrayList;

public interface WorkPlaceServiceFacade {
    public ArrayList<WorkSiteTO> getWorkSiteList();
    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList);

    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
}
