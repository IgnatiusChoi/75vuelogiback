package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;
import kr.co.seoulit.erp.logistic.production.dao.WorkPlaceDAO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WorkPlaceServiceFacadeImpl implements kr.co.seoulit.erp.logistic.production.servicefacade.WorkPlaceServiceFacade {

    @Autowired
    private WorkPlaceDAO workPlaceDAO;

    @Override
    public ArrayList<WorkSiteTO> getWorkSiteList() {
        return workPlaceDAO.selectWorkSiteList();
    }

    @Override
    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList) {
        workPlaceDAO.insertWorkPlaceList(newWorkPlaceList);
    }

    @Override
    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList) {
        workPlaceDAO.deleteWorkPlaceList(newWorkPlaceList);
    }
}
