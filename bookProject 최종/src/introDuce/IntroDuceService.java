package introDuce;

import java.util.List;

public interface IntroDuceService {

	List<IntroDuce> findAllList();
	
	void create(IntroDuce introDuce);
	
	void delete(String introDuceId);
	
	void modify(IntroDuce introDuce);
	
	IntroDuce findList(String introDuceId);
}
