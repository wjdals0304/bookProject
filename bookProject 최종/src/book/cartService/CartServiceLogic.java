package book.cartService;

import java.util.List;

import book.dao.BasketDao;
import book.dao.BasketItemDao;
import book.dao.BookDao;
import book.dao.mybatis.BasketDaoLogic;
import book.dao.mybatis.BasketItemDaoLogic;
import book.dao.mybatis.BookDaoLogic;
import book.domain.Basket;
import book.domain.BasketItem;
import book.domain.Book;
import book.domain.Zzim;
import book.domain.ZzimItem;

public class CartServiceLogic implements CartService {

	private BasketDao basketDao;
	private BasketItemDao basketItemDao;
	private BookDao bookDao;
	
	public CartServiceLogic() {
		
		this.basketDao = new BasketDaoLogic();
		this.basketItemDao = new BasketItemDaoLogic();
		this.bookDao = new BookDaoLogic();
	}

	@Override
	public void createZzim(ZzimItem zzimItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerZzimItem(ZzimItem zzimItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeZzimItem(String zzimItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Zzim findZzim(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBasket(String memberId) {

		basketDao.createBasket(memberId);
	}

	@Override
	public void registerBasketItem(BasketItem basketItem) {

		//중복 제거
		List<BasketItem> basketItemList= basketItemDao.retrieveAllByBasketId(basketItem.getBasketId());
		
		boolean exist = false;
		for ( BasketItem basketItem2 : basketItemList) {
			if ( basketItem2.getBook().getBookId().equals(basketItem.getBook().getBookId()) ) {
				exist = true;
			}
		}
		
		if ( exist == false ) {
			basketItemDao.create(basketItem);
		}
	}

	@Override
	public void modifyBasketItem(BasketItem basketItem) {
		
		basketItemDao.update(basketItem);
	}

	@Override
	public void removeBasketItem(String basketItemId) {

		basketItemDao.delete(basketItemId);
	}
	
	@Override
	public Basket findBasket(String memberId) {
		
		Basket basket = basketDao.retrieveByMemberId(memberId);
		
		List<BasketItem> basketItemList = basketItemDao.retrieveAllByBasketId(basket.getBasketId());
		
		for ( BasketItem basketItem : basketItemList ) {
			Book book = bookDao.retrieveBook(basketItem.getBook().getBookId());
			basketItem.setBook(book);
		}
		
		basket.setBasketItemList(basketItemList);
		
		return basket;
	}

	@Override
	public void removeBasketItemWithLogin(String basketId) {
		
		List<String> basketItemIdList = basketItemDao.removeBasketItemWithLogin(basketId);
		
		for ( String basketItemId : basketItemIdList ) {
			basketItemDao.delete(basketItemId);
		}
	}
}
