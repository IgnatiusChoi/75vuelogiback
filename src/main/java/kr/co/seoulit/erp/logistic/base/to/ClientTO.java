package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.*;
@Data
@EqualsAndHashCode(callSuper = false)
public class ClientTO extends BaseTO {
    private String socialSecurityNumber;
    private String customerType;
    private String businessLicenseNumber;
    private String customerCeo;
    private String customerName;
    private String workplaceCode;
    private String customerCode;
    private String customerBasicAddress;
    private String customerBusinessConditions;
    private String customerZipCode;
    private String customerDetailAddress;
    private String customerNote;
    private String customerBusinessItems;
    private String customerTelNumber;
    private String customerFaxNumber;

}
