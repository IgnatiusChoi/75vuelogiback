package kr.co.seoulit.erp.logistic.production.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MpsTO  extends BaseTO{

	private String mpsPlanDate;
	private String mpsNo;
	private String contractDetailNo;
	private String dueDateOfMps; // 납기일
	private String salesPlanNo;
	private String itemCode;
	private String itemName;
	private String mpsPlanAmount;
	private String mrpApplyStatus;
	private String description;
	private String unitOfMps;
	private String mpsPlanClassification;
	private String scheduledEndDate; // 출하예정일


	public MpsTO(){

	}
	public MpsTO (ContractDetailInMpsAvailableTO contractDetail) {
		this.setMpsPlanDate(contractDetail.getMpsPlanDate());
		this.setContractDetailNo(contractDetail.getContractDetailNo());
		this.setItemCode(contractDetail.getItemCode());
		this.setItemName(contractDetail.getItemName());
		this.setUnitOfMps(contractDetail.getUnitOfContract());
		this.setDueDateOfMps(contractDetail.getDueDateOfContract());
		this.setScheduledEndDate(contractDetail.getScheduledEndDate());
		this.setDescription(contractDetail.getDescription());
		this.setMpsPlanAmount(contractDetail.getEstimateAmount());
		this.setMpsPlanClassification(contractDetail.getPlanClassification());
	}
}
