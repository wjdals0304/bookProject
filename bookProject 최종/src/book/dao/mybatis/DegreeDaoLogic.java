package book.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.DegreeDao;
import book.dao.mapper.DegreeMapper;
import book.domain.Degree;

public class DegreeDaoLogic implements DegreeDao{

	@Override
	public Degree retrieveDegree(String degreeId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		DegreeMapper mapper = session.getMapper(DegreeMapper.class);
		
		Degree degree = mapper.retrieveDegree(degreeId);

		session.close();
		
		return degree;
	}

	@Override
	// 전체 등급 가져오기
	public List<Degree> retrieveAllDegreeList() {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		DegreeMapper mapper = session.getMapper(DegreeMapper.class);
		List<Degree> degreeList = mapper.retrieveAllDegreeList();
		session.close();
		return degreeList;
	}






}
