package kr.co.seoulit.erp.logistic.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.seoulit.erp.logistic.base.servicefacade.ClientServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;

import kr.co.seoulit.erp.logistic.base.to.FinancialTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/logi/*")
public class ClientController {
    @Autowired
    private ClientServiceFacade ClientSF;

    private ModelMap modelMap = new ModelMap();

    @RequestMapping(value = "/base/searchClientList", method = RequestMethod.GET)
    public ModelMap searchClientList(){
        try {
            ArrayList<ClientTO> clientInfo = ClientSF.searchClientList();
            modelMap.put("clientInfo", clientInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @RequestMapping(value = "/base/searchClientDetailList", method = RequestMethod.GET)
    public ModelMap searchClientDetailList(@RequestParam String customerCode){
        System.out.println("설마 범인은 너냐...?");
        try {
            ArrayList<ClientTO> clientDetailInfo = ClientSF.searchClientDetailList(customerCode);
            modelMap.put("clientDetailInfo", clientDetailInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @RequestMapping(value = "/base/searchFinanceList", method = RequestMethod.GET)
    public ModelMap searchFinanceList(){
        try {
            ArrayList<FinancialTO> financeInfo = ClientSF.searchFinanceList();
            modelMap.put("financeInfo", financeInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @RequestMapping(value = "/base/searchFinanceDetailList", method = RequestMethod.GET)
    public ModelMap searchFinanceDetailList(@RequestParam String code){
        System.out.println("여기로 오는거 맞는지 테스트중");
        try {
            ArrayList<FinancialTO> financedetailInfo = ClientSF.searchFinanceDetailList(code);
            modelMap.put("financeDetailInfo", financedetailInfo);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @PostMapping("/base/insertClient")
    public ModelMap insertClient(@RequestBody Map<String, Object> data){
        ObjectMapper mapper = new ObjectMapper();
        ClientTO clientdata=mapper.convertValue(data,ClientTO.class);
        System.out.println(clientdata);
        try {
            ClientSF.insertClient(clientdata);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @PostMapping("/base/deleteClient")
    public ModelMap deleteClient(@RequestBody ClientTO data){
        System.out.println(data);
        try {
            ClientSF.deleteClient(data);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @PostMapping("/base/updateClient")
    public ModelMap updateClient(@RequestBody Map<String, Object> data){
        ObjectMapper mapper = new ObjectMapper();
        ClientTO clientdata=mapper.convertValue(data,ClientTO.class);
        System.out.println(clientdata);
        try {
            ClientSF.updateClient(clientdata);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }

    @PostMapping("/base/insertFinance")
    public ModelMap insertFinance(@RequestBody Map<String, Object> data){
        ObjectMapper mapper = new ObjectMapper();
        FinancialTO clientdata=mapper.convertValue(data,FinancialTO.class);
        System.out.println(clientdata);
        try {
            ClientSF.insertFinance(clientdata);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @PostMapping("/base/deleteFinance")
    public ModelMap deleteFinance(@RequestBody FinancialTO data){
        System.out.println(data);
        try {
            ClientSF.deleteFinance(data);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
    @PostMapping("/base/updateFinance")
    public ModelMap updateFinance(@RequestBody Map<String, Object> data){
        ObjectMapper mapper = new ObjectMapper();
        FinancialTO clientdata=mapper.convertValue(data,FinancialTO.class);
        System.out.println(clientdata);
        try {
            ClientSF.updateFinance(clientdata);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }
}
