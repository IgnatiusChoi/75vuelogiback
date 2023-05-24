package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.to.ClientTO;
import kr.co.seoulit.erp.logistic.base.to.FinancialTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClientServiceFacade {

    public ArrayList<ClientTO> searchClientList();
    public ArrayList<ClientTO> searchClientDetailList(String customerCode);
    public ArrayList<FinancialTO> searchFinanceList();
    public ArrayList<FinancialTO> searchFinanceDetailList(String Code);
    public ArrayList<ClientTO> insertClient(ClientTO clientdata);
    public ArrayList<ClientTO> updateClient(ClientTO clientdata);
    public ArrayList<ClientTO> deleteClient(ClientTO clientdata);
    public ArrayList<FinancialTO> insertFinance(FinancialTO clientdata);
    public ArrayList<FinancialTO> updateFinance(FinancialTO clientdata);
    public ArrayList<FinancialTO> deleteFinance(FinancialTO clientdata);
}
