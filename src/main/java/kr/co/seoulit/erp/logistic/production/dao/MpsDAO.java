package kr.co.seoulit.erp.logistic.production.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;
import kr.co.seoulit.erp.logistic.sales.to.ContractDetailTO;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.production.to.MpsTO;

@Mapper
public interface MpsDAO {

	public List<MpsTO> selectMpsCount(String mpsPlanDate);

	public void insertMps(MpsTO TO);

	public void updateMps(MpsTO TO);

	public void deleteMps(MpsTO TO);

	public ArrayList<MpsTO> selectMpsList(HashMap<String, String> param);

	public void changeMrpApplyStatus(HashMap<String, String> param);

	/**
	 * ContractDetailDAO 에서 MpsDAO로 이동
 	 */

	public ArrayList<ContractDetailInMpsAvailableTO> selectContractDetailListInMpsAvailable(
			String searchCondition, String startDate, String endDate);

	public void changeMpsStatusOfContractDetail(HashMap<String, String> param);

	public List<MpsTO> searchMpsList();

}
