package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.dao.ItemDAO;
import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Service
public class ItemServiceFacadeImpl implements ItemServiceFacade{

    @Autowired
    private ItemDAO itemDAO;

    private ModelMap modelMap = new ModelMap();

    @Override
    public Map<String, Object> searchItemList() {
        ArrayList<ItemTO> itemList=itemDAO.searchItemList();
        try{
            modelMap.put("gridRowJson", itemList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> searchItemGroupList() {
        ArrayList<ItemGroupTO> itemGroupList=itemDAO.searchItemGroupList();
        try{
            modelMap.put("gridRowJson", itemGroupList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e.getMessage());
        }
        return modelMap;
    }
}
