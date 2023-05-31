package kr.co.seoulit.erp.logistic.base.servicefacade;


import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Map;

public interface ItemServiceFacade {

    public ModelMap searchItemList();
    public ModelMap searchItemGroupList();
    public void batchListProcess(ItemTO batchList);
    public void itemGroupBatchListProcess(ItemGroupTO batchList);

}
