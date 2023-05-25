package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface WorkSiteServiceFacade {


    public ArrayList<WorkSiteTO> getWorkSiteList();

    public ArrayList<WorkSiteLogTO> getProductionProcessCode(HashMap<String, String> map);

//    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
//
//    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
}
