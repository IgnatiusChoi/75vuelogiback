package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.logistic.production.to.*;

public interface WorkOrderServiceFacade {

    //작업지시 Tab -  작업지시 필요항목 조회
    public HashMap<String, Object> getWorkOrderableMrpList();

    //작업지시 Tab -  작업지시 모의전개
    public HashMap<String, Object> getWorkOrderSimulationList(String mrpNo,String mrpGatheringNo);

    //작업지시 Tab - 작업지시 모의전개 버튼 누른 후 - 실제 작업 지시 버튼
    public HashMap<String, Object> workOrder(String mrpGatheringNo, String workPlaceCode, String productionProcess);

    //작업지시현황 Tab - 작업지시현황조회
    public ArrayList<WorkOrderInfoTO> getWorkOrderInfoListStatus();


    public int editCellBlur(String workOrderNo, String actualCompletionAmount);

    //작업지시현황 Tab - 작업완료등록
    public HashMap<String, Object> workOrderCompletion(String workOrderNo, String actualCompletionAmount);

    //생산실적관리 Tab - 생산실적관리조회
    public ArrayList<ProductionPerformanceInfoTO> getProductionPerformanceInfoList();













    public ArrayList<WorkOrderInfoTO> getWorkOrderInfoList();

    public HashMap<String, Object> showWorkSiteSituation(String workSiteCourse, String workOrderNo,
                                                         String itemClassIfication);
    public void workCompletion(HashMap<String, ArrayList<WorkSiteSimulationTO>> workOrderInfo);
}
