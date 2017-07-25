package introDuce;

import java.util.List;


public interface IntroDuceDao {


	List<IntroDuce> findAllList();
	
	void create(IntroDuce introDuce);
	
	void delete(String introDuceId);

	void update(IntroDuce introDuce);
	
	IntroDuce find(String intro);
}
