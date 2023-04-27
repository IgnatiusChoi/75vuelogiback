package kr.co.seoulit.erp.logistic.base.dao;

import kr.co.seoulit.erp.logistic.base.to.ClientTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ClientDAO {
    public ArrayList<ClientTO> searchClientList();
    public int insertClient(ClientTO clientdata);

    public int deleteClient(ClientTO clientdata);
}
