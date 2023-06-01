package kr.co.seoulit.erp.logistic.production.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "WORK_SITE_LOG")

public class WorkSiteLog {

    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private String workOrderNo;
    private String itemCode;
    private String itemName;
    private String workSiteName;
    private String workDate;
    private String productionProcessCode;
    private String productionProcessName;


    @Transient
    private String progress;

    public WorkSiteLog(){}

}
