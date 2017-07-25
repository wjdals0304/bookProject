package book.dao;

import java.util.List;

import book.domain.ZzimItem;

public interface ZzimItemDao {

	public void create(ZzimItem zzimItem);
	public void update(ZzimItem zzimItem);
	public void delete(String zzimItemId);
	public List<ZzimItem> retrieveAllByBasketId(String zzimId);
}
