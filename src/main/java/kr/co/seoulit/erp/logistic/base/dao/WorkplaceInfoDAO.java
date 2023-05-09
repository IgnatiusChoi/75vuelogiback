package kr.co.seoulit.erp.logistic.base.dao;

import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;
import kr.co.seoulit.erp.logistic.base.to.WorkplaceInfoTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


@Mapper
public interface WorkplaceInfoDAO {

    public ArrayList<WorkplaceInfoTO> getWorkplaceDetailList(String workplaceCode);

    public ArrayList<WorkplaceInfoTO> getWorkplaceList();

    public void deleteWorkplaceCode(String workplaceCode);

    public void insertWorkplace(WorkplaceInfoTO workplaceInfoTO);

    void updateWorkplaceCode(WorkplaceInfoTO workplaceInfoTO);
}

