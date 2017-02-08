package dao;

import model.Stock;

public class DaoTest {
	public static void main(String[] args) {
		StockDao dao = StockDao.getInstance();
		
		Stock stock = new Stock();
		stock.setCode("0001");
		stock.setCnt(3);
		System.out.println(dao.selectCode(stock.getCode()));
//		dao.createStock(stock);
//		dao.updateStock(stock);
	}
	
}
