package book.dao.mapper;

import java.util.List;

import book.domain.BasketItem;

public interface BasketItemMapper {

	public void create(BasketItem basketItem);
	public void update(BasketItem basketItem);
	public void delete(String basketItemId);
	public List<String> removeBasketItemWithLogin(String basketId);
	public List<BasketItem> retrieveAllByBasketId(String basketId);
	
}
