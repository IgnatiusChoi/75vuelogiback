package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.domain.WorkSite;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface WorkSiteServiceFacade {


    //public ArrayList<WorkSiteTO> getWorkSiteList();
    /*****************************
     작업장/작업장 로그 = 작업장 조회(JPA)
     *****************************/
    public List<WorkSite> getWorkSiteList();

//    public ArrayList<WorkSiteLogTO> getProductionProcessCode(HashMap<String, String> map);




//    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
//
//    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
}
