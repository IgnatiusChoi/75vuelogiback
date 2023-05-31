package kr.co.seoulit.erp.logistic.production.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@ToString
public class MrpGathering {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String mrpGatheringNo;
    private String orderOrProductionStatus;
    private String itemCode;
    private String itemName;
    private String unitOfMrpGathering;
    private String claimDate;
    private String dueDate;
    private int necessaryAmount;
    private int mrpGatheringSeq;
    private String requestStatus;
    private String outsourcStatus;


}
