package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.dao.ClientDAO;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;
import kr.co.seoulit.erp.logistic.base.to.FinancialTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class ClientApplicationServiceImpl implements ClientApplicationService{

    @Autowired
    private ClientDAO clientDAO;
    @Override
    public ArrayList<ClientTO> searchClientList() {
        return clientDAO.searchClientList();
    }

    @Override
    public ArrayList<ClientTO> searchClientDetailList(String customerCode) {
        return clientDAO.searchClientDetailList(customerCode);
    }

    @Override
    public ArrayList<FinancialTO> searchFinanceList() {
        return clientDAO.searchFinanceList();
    }

    @Override
    public ArrayList<FinancialTO> searchFinanceDetailList(String Code) {
        return clientDAO.searchFinanceDetailList(Code);
    }

    @Override
    public ArrayList<ClientTO> insertClient(ClientTO clientdata) {
        clientDAO.insertClient(clientdata);
        return null;
    }

    @Override
    public ArrayList<ClientTO> updateClient(ClientTO clientdata) {
        clientDAO.updateClient(clientdata);
        return null;
    }

    @Override
    public ArrayList<ClientTO> deleteClient(ClientTO clientdata) {
        clientDAO.deleteClient(clientdata);
        return null;
    }

    @Override
    public ArrayList<FinancialTO> insertFinance(FinancialTO clientdata) {
        clientDAO.insertFinance(clientdata);
        return null;
    }

    @Override
    public ArrayList<FinancialTO> updateFinance(FinancialTO clientdata) {
        clientDAO.updateFinance(clientdata);
        return null;
    }

    @Override
    public ArrayList<FinancialTO> deleteFinance(FinancialTO clientdata) {
        clientDAO.deleteFinance(clientdata);
        return null;
    }
}
