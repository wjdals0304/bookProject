package book.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.CommentDao;
import book.dao.mapper.CommentMapper;
import book.domain.Comment;

public class CommentDaoLogic implements CommentDao {

	@Override
	public void create(Comment comment) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);

		mapper.create(comment);
		
		session.close();
	}

	@Override
	public void delete(String commentId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		mapper.delete(commentId);
		
		session.close();
	}

	@Override
	public List<Comment> retrieveAllByBookIdForPasing(HashMap<String, Object> map) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		List<Comment> commentList = mapper.retrieveAllByBookIdForPasing(map);
		
		session.close();
		
		return commentList;
	}

	@Override
	public List<Comment> retrieveAllByBookId(String bookId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		
		List<Comment> commentList = mapper.retrieveAllByBookId(bookId);
		
		session.close();
		
		return commentList;
	}
}
