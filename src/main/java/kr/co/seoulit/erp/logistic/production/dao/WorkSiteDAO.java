package kr.co.seoulit.erp.logistic.production.dao;

import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface WorkSiteDAO {

    public ArrayList<WorkSiteTO> selectWorkSiteList();
    public ArrayList<WorkSiteLogTO> selectProductionProcessCode(HashMap<String, String> map);

//    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList);

//    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
}

