package introDuce;

import java.util.List;

public class IntroDuceServiceLogic implements IntroDuceService {


	
	@Override
	public List<IntroDuce> findAllList() {
		// 
		IntroDuceDao introDuceDao = new IntroDuceDaoLogic();
		return introDuceDao.findAllList();
	}

	@Override
	public void create(IntroDuce introDuce) {
		
		IntroDuceDao introDuceDao = new IntroDuceDaoLogic();
		// TODO Auto-generated method stub
		introDuceDao.create(introDuce);
	}

	@Override
	public void delete(String introDuceId) {
		// TODO Auto-generated method stub
		IntroDuceDao introDuceDao = new IntroDuceDaoLogic();
		introDuceDao.delete(introDuceId);
	}

	@Override
	public void modify(IntroDuce introDuce) {
		// TODO Auto-generated method stub
		IntroDuceDao introDuceDao = new IntroDuceDaoLogic();
		introDuceDao.update(introDuce);
	}

	@Override
	public IntroDuce findList(String introDuceId) {
		// TODO Auto-generated method stub
		IntroDuceDao introDuceDao = new IntroDuceDaoLogic();
		return introDuceDao.find(introDuceId);
	}

}
