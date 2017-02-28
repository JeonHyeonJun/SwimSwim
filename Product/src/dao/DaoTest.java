package dao;

import model.Stock;

public class DaoTest {
	public static void main(String[] args) {
		StockDao dao = StockDao.getInstance();
		
		Stock stock = new Stock();
		stock.setName("허니버터칩");
		stock.setCnt(2);
		System.out.println(dao.selectCnt(stock.getCnt()));
//		dao.createStock(stock);
//		dao.updateStock(stock);
	}
	
}
