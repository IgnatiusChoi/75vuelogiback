package kr.co.seoulit.erp.logistic.base.servicefacade;


import kr.co.seoulit.erp.logistic.base.dao.DeptInfoDAO;
import kr.co.seoulit.erp.logistic.base.to.DeptInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeptInfoServiceFacadeImpl implements DeptInfoServiceFacade {
    @Autowired
    private DeptInfoDAO deptInfoDAO;
    public ArrayList<DeptInfoTO> getDeptInfo() {
        return deptInfoDAO.getDeptInfo();
    }
}
