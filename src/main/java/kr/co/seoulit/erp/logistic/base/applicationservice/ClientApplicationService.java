package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.to.ClientTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClientApplicationService {
    public ArrayList<ClientTO> searchClientList();
    public ArrayList<ClientTO> insertClient(ClientTO clientdata);
    public ArrayList<ClientTO> deleteClient(ClientTO clientdata);
}
