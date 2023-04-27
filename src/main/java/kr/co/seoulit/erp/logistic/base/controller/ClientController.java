package kr.co.seoulit.erp.logistic.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.seoulit.erp.logistic.base.servicefacade.ClientServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;

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
    public ModelMap getCompanyInfo(){
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

}
