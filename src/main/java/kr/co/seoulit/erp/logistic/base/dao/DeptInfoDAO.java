package kr.co.seoulit.erp.logistic.base.dao;

import kr.co.seoulit.erp.logistic.base.to.DeptInfoTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DeptInfoDAO {

    public ArrayList<DeptInfoTO> getDeptInfo();
}
