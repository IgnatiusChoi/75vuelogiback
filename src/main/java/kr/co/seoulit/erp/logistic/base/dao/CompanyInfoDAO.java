package kr.co.seoulit.erp.logistic.base.dao;

import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CompanyInfoDAO {
    public ArrayList<CompanyInfoTO> getCompanyInfo();
}
