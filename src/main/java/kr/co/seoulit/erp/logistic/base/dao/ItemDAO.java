package kr.co.seoulit.erp.logistic.base.dao;

import java.util.ArrayList;
import java.util.Map;

import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.base.to.ItemInfoTO;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;

@Mapper
public interface ItemDAO {

	public ArrayList<ItemInfoTO> selectAllItemList();

	public ArrayList<ItemInfoTO> selectItemList(Map<String, String> params);

	public void insertItem(ItemTO TO);

	public void updateItem(ItemTO TO);

	public void deleteItem(ItemTO TO);

	public int getStandardUnitPrice(String itemCode);

	public int getStandardUnitPriceBox(String itemCode);

	public ArrayList<ItemInfoTO> selectOptionItemList();

	public ArrayList<ItemTO> searchItemList();

	public ArrayList<ItemGroupTO> searchItemGroupList();
}
