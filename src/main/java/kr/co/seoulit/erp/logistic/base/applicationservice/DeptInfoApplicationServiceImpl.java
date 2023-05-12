package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.dao.DeptInfoDAO;
import kr.co.seoulit.erp.logistic.base.to.DeptInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DeptInfoApplicationServiceImpl implements DeptInfoApplicationService {
    @Autowired
    private DeptInfoDAO deptInfoDAO;

    public ArrayList<DeptInfoTO> getDeptInfo(){
        return deptInfoDAO.getDeptInfo();
    }
}
