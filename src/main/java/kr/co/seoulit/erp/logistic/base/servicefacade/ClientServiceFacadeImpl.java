package kr.co.seoulit.erp.logistic.base.servicefacade;

import kr.co.seoulit.erp.logistic.base.applicationservice.ClientApplicationService;
import kr.co.seoulit.erp.logistic.base.to.ClientTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ClientServiceFacadeImpl implements ClientServiceFacade{
    @Autowired
    private ClientApplicationService clientAS;
    public ArrayList<ClientTO> searchClientList(){
        ArrayList<ClientTO> list = clientAS.searchClientList();
        return list;
    }

    @Override
    public ArrayList<ClientTO> insertClient(ClientTO clientdata) {
        ArrayList<ClientTO> result = clientAS.insertClient(clientdata);
        return result;
    }

    @Override
    public ArrayList<ClientTO> deleteClient(ClientTO clientdata) {
        ArrayList<ClientTO> result = clientAS.deleteClient(clientdata);
        return result;
    }

    ;
}
