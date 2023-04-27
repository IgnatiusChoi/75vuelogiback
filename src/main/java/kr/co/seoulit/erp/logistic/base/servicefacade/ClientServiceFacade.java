package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.to.ClientTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ClientServiceFacade {

    public ArrayList<ClientTO> searchClientList();
    public ArrayList<ClientTO> insertClient(ClientTO clientdata);
    public ArrayList<ClientTO> deleteClient(ClientTO clientdata);
}
