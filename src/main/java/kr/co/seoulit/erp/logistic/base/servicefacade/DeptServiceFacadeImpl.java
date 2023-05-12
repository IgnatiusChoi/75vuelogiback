package kr.co.seoulit.erp.logistic.base.servicefacade;


import kr.co.seoulit.erp.logistic.base.applicationservice.DeptInfoApplicationService;
import kr.co.seoulit.erp.logistic.base.to.DeptInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeptServiceFacadeImpl implements DeptServiceFacade {
    @Autowired
    private DeptInfoApplicationService deptAS;

    @Override
    public ArrayList<DeptInfoTO> getDeptInfo() {
        ArrayList<DeptInfoTO> deptInfo =deptAS.getDeptInfo();
        return deptInfo;
    }
}
