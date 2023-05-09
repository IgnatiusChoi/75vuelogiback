package kr.co.seoulit.erp.logistic.base.applicationservice;


import kr.co.seoulit.erp.logistic.base.to.WorkplaceInfoTO;

import java.util.ArrayList;

public interface WorkplaceApplicationService {

    public ArrayList<WorkplaceInfoTO> getWorkplaceDetailList(String workplaceCode);
    public ArrayList<WorkplaceInfoTO> getWorkplaceList();

    public void deleteWorkplaceCode(String workplaceCode);
    public void insertWorkplace(WorkplaceInfoTO workplaceInfoTO);

    void updateWorkplaceCode(WorkplaceInfoTO workplaceInfoTO);

}
