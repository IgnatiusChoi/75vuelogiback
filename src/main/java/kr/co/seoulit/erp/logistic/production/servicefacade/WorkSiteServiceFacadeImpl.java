package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.dao.WorkSiteDAO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class WorkSiteServiceFacadeImpl implements kr.co.seoulit.erp.logistic.production.servicefacade.WorkSiteServiceFacade {

    @Autowired
    private WorkSiteDAO workSiteDAO;

    @Override
    public ArrayList<WorkSiteTO> getWorkSiteList() {
        return workSiteDAO.selectWorkSiteList();
    }

    @Override
    public ArrayList<WorkSiteLogTO> getProductionProcessCode(HashMap<String, String> map) {
        return workSiteDAO.selectProductionProcessCode(map);
    }

//    @Override
//    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList) {
//        workSiteDAO.insertWorkPlaceList(newWorkPlaceList);
//    }
//
//    @Override
//    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList) {
//        workSiteDAO.deleteWorkPlaceList(newWorkPlaceList);
//    }
}
