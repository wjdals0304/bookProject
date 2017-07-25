package book.dao.mapper;

import java.util.HashMap;
import java.util.List;

import book.domain.Comment;

public interface CommentMapper {

	public void create(Comment comment);
	public void delete(String commentId);
	public List<Comment> retrieveAllByBookIdForPasing(HashMap<String, Object> map);
	public List<Comment> retrieveAllByBookId(String bookId);
}
