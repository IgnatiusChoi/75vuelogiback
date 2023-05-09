package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.dao.CompanyInfoDAO;
import kr.co.seoulit.erp.logistic.base.dao.WorkplaceInfoDAO;
import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;
import kr.co.seoulit.erp.logistic.base.to.WorkplaceInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class WorkplaceInfoApplicationServiceImpl implements WorkplaceApplicationService{

    @Autowired
    private WorkplaceInfoDAO workplaceInfoDAO;

    @Override
    public ArrayList<WorkplaceInfoTO> getWorkplaceDetailList(String workplaceCode) {
        ArrayList<WorkplaceInfoTO> workplaceDetailList = workplaceInfoDAO.getWorkplaceDetailList(workplaceCode);
        return workplaceDetailList;
    }

    @Override
    public ArrayList<WorkplaceInfoTO> getWorkplaceList() {
        return workplaceInfoDAO.getWorkplaceList();
    }

    @Override
    public void deleteWorkplaceCode(String workplaceCode) {
        workplaceInfoDAO.deleteWorkplaceCode(workplaceCode);
    }

    @Override
    public void insertWorkplace(WorkplaceInfoTO workplaceInfoTO) {
        workplaceInfoDAO.insertWorkplace(workplaceInfoTO);
    }

    @Override
    public void updateWorkplaceCode(WorkplaceInfoTO workplaceInfoTO) {
        workplaceInfoDAO.updateWorkplaceCode(workplaceInfoTO);

    }
}
