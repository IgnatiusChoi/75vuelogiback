package kr.co.seoulit.erp.logistic.base.servicefacade;


import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Map;

public interface ItemServiceFacade {

    public Map<String, Object> searchItemList();
    public Map<String, Object> searchItemGroupList();
}
