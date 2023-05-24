package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.production.applicationservice.WorkOrderApplicationService;
import kr.co.seoulit.erp.logistic.production.dao.WorkOrderDAO;
import kr.co.seoulit.erp.logistic.production.to.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WorkOrderServiceFacadeImpl implements WorkOrderServiceFacade {

    @Autowired
    private WorkOrderDAO workOrderDAO;
    private WorkOrderApplicationService workOrderAS;

    //작업지시 Tab -  작업지시 필요항목 조회
    @Override
    public HashMap<String, Object> getWorkOrderableMrpList() {

        HashMap<String, Object> result = new HashMap<>();

        HashMap<String, Object> map = new HashMap<>();

        workOrderDAO.getWorkOrderableMrpList(map);

        result.put("gridRowJson", map.get("result"));
        result.put("errorCode", map.get("errorCode"));
        result.put("errorMsg", map.get("errorMsg"));

        System.out.println("데이터확인용");
        System.out.println(result);

        return result;
    }

    //작업지시 Tab -  작업지시 모의전개
    @Override
    public HashMap<String, Object> getWorkOrderSimulationList(String mrpNo,String mrpGatheringNo) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("mrpGatheringNo", mrpGatheringNo);
        param.put("mrpNo", mrpNo);

        workOrderDAO.getWorkOrderSimulationList(param);

        System.out.println("모의전개 파람쓰: "+param);

        HashMap<String, Object> map = new HashMap<>();
        map.put("result",param.get("result"));
        map.put("errorCode",param.get("ERROR_CODE"));
        map.put("errorMsg",param.get("ERROR_MSG"));
        System.out.println("모의전개: "+map);

        return param;
    }

    //작업지시 Tab - 작업지시 모의전개 버튼 누른 후 - 실제 작업 지시 버튼
    @Override
    public HashMap<String, Object> workOrder(String mrpGatheringNo, String workPlaceCode, String productionProcess) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("mrpGatheringNo", mrpGatheringNo);
        param.put("workPlaceCode", workPlaceCode);
        param.put("productionProcess", productionProcess);

        System.out.println("mrpGatheringNo: "+mrpGatheringNo);
        System.out.println("workPlaceCode: "+workPlaceCode);
        System.out.println("productionProcess: "+productionProcess);

        workOrderDAO.workOrder(param);

        return param;
    }

    //작업지시현황 Tab - 작업지시현황조회
    @Override
    public ArrayList<WorkOrderInfoTO> getWorkOrderInfoListStatus() {
        return workOrderDAO.selectWorkOrderInfoListStatus();
    }

    @Override
    public int editCellBlur(String workOrderNo, String actualCompletionAmount) {
        int count = workOrderDAO.editCellBlur(workOrderNo, actualCompletionAmount);
        return count;
    }

    //작업지시현황 Tab - 작업완료등록
    @Override
    public HashMap<String, Object> workOrderCompletion(String workOrderNo, String actualCompletionAmount) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("workOrderNo", workOrderNo);
        param.put("actualCompletionAmount", actualCompletionAmount);

        workOrderDAO.workOrderCompletion(param);

        return param;
    }

    //생산실적관리 Tab - 생산실적관리조회
    @Override
    public ArrayList<ProductionPerformanceInfoTO> getProductionPerformanceInfoList() {

        return workOrderDAO.selectProductionPerformanceInfoList();
    }
















    @Override
    public ArrayList<WorkOrderInfoTO> getWorkOrderInfoList() {

        return workOrderAS.getWorkOrderInfoList();

    }



    @Override
    public HashMap<String, Object> showWorkSiteSituation(String workSiteCourse, String workOrderNo,
                                                         String itemClassIfication) {

        return workOrderAS.showWorkSiteSituation(workSiteCourse, workOrderNo, itemClassIfication);

    }

    @Override
    public void workCompletion(HashMap<String, ArrayList<WorkSiteSimulationTO>> workOrderInfo) {

        workOrderAS.workCompletion(workOrderInfo);

    }
}
