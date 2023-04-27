package kr.co.seoulit.erp.logistic.base.applicationservice;

import kr.co.seoulit.erp.logistic.base.dao.ClientDAO;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;
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
    public ArrayList<ClientTO> insertClient(ClientTO clientdata) {
        clientDAO.insertClient(clientdata);
        return null;
    }

    @Override
    public ArrayList<ClientTO> deleteClient(ClientTO clientdata) {
        clientDAO.deleteClient(clientdata);
        return null;
    }
}
