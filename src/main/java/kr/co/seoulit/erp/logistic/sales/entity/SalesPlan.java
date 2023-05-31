package kr.co.seoulit.erp.logistic.sales.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SalesPlan {
    @Id
    private String salesPlanNo;

    private String itemCode;

    private String itemName;

    private String unitOfSales;

    private String salesPlanDate;

    private String dueDateOfSales;

    private String salesAmount;

    private String unitPriceOfSales;

    private String sumPriceOfSales;

    private String mpsApplyStatus;

    private String description;




}
