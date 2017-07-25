package book.cartService;

import book.domain.Basket;
import book.domain.BasketItem;
import book.domain.Zzim;
import book.domain.ZzimItem;

public interface CartService {

	public void createZzim(ZzimItem zzimItem);
	public void registerZzimItem(ZzimItem zzimItem);
	public void removeZzimItem(String zzimItemId);
	public Zzim findZzim(String memberId);
	
	public void createBasket(String memberId);
	public void registerBasketItem(BasketItem basketItem);
	public void modifyBasketItem(BasketItem basketItem);
	public void removeBasketItem(String basketItemId);
	public void removeBasketItemWithLogin(String memberId);
	public Basket findBasket(String memberId);
}
