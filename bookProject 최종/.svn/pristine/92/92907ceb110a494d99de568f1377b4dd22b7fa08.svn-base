package book.UserService;

import java.util.HashMap;
import java.util.List;

import book.domain.Comment;
import book.domain.Degree;
import book.domain.Member;

public interface UserService {

	public Member loginCheck(String loginId);
	public String checkLoginId(String loginId);
	public void registerMember(Member member);
	
	public void registerComment(Comment comment);
	public void removeComment(String commentId);
	public List<Comment> findComment(String bookId);
	public List<Comment> findCommentForPasing(HashMap<String, Object> map);
	
	public Degree findDegree(String degreeId);
}
