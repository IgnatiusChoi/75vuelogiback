package kr.co.seoulit.erp.logistic.base.dao;

import kr.co.seoulit.erp.logistic.base.to.ClientTO;
import kr.co.seoulit.erp.logistic.base.to.FinancialTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ClientDAO {
    public ArrayList<ClientTO> searchClientList();
    public ArrayList<ClientTO> searchClientDetailList(String customerCode);
    public ArrayList<FinancialTO> searchFinanceList();
    public ArrayList<FinancialTO> searchFinanceDetailList(String Code);
    public int insertClient(ClientTO clientdata);
    public boolean updateClient(ClientTO clientdata);

    public int deleteClient(ClientTO clientdata);
    public int insertFinance(FinancialTO clientdata);
    public boolean updateFinance(FinancialTO clientdata);

    public int deleteFinance(FinancialTO clientdata);
}
