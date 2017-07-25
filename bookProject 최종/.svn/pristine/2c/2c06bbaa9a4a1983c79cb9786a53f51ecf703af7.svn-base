package book.UserService;

import java.util.HashMap;
import java.util.List;

import book.dao.BookDao;
import book.dao.CommentDao;
import book.dao.DegreeDao;
import book.dao.MemberDao;
import book.dao.mybatis.BookDaoLogic;
import book.dao.mybatis.CommentDaoLogic;
import book.dao.mybatis.DegreeDaoLogic;
import book.dao.mybatis.MemberDaoLogic;
import book.domain.Book;
import book.domain.Comment;
import book.domain.Degree;
import book.domain.Member;

public class UserServiceLogic implements UserService {

	private MemberDao memberDao;
	private CommentDao commentDao;
	private BookDao bookDao;
	private DegreeDao degreeDao;
	
	public UserServiceLogic() {
		this.memberDao = new MemberDaoLogic();
		this.commentDao = new CommentDaoLogic();
		this.bookDao = new BookDaoLogic();
		this.degreeDao = new DegreeDaoLogic();
	}
	
	@Override
	public Member loginCheck(String loginId) {
		return memberDao.loginCheck(loginId);
	}

	@Override
	public String checkLoginId(String loginId) {
		
		return memberDao.checkLoginId(loginId);
	}

	@Override
	public void registerMember(Member member) {
		
		memberDao.create(member);
	}

	@Override
	public void registerComment(Comment comment) {
		
		commentDao.create(comment);
		
		List<Comment> commentList = commentDao.retrieveAllByBookId(comment.getBookId());
		
		int allGpa = 0;
		for(Comment commentGpa : commentList){
			allGpa += commentGpa.getGpa();
		}
		
		double avgGpa = allGpa/commentList.size();
		
		Book book = bookDao.retrieveBook(comment.getBookId());
		book.setAllGpa(avgGpa);

		bookDao.updateGpa(book);
	}

	@Override
	public void removeComment(String commentId) {

		commentDao.delete(commentId);
	}

	@Override
	public List<Comment> findComment(String bookId) {

		return commentDao.retrieveAllByBookId(bookId);
	}
	
	@Override
	public Degree findDegree(String degreeId) {

		return degreeDao.retrieveDegree(degreeId);
	}

	@Override
	public List<Comment> findCommentForPasing(HashMap<String, Object> map) {
		
		String index = (String) map.get("index");
		int indexInt = Integer.parseInt(index);
		int a = 1;
		int b = -5;
		for (int i = 0; i < indexInt; i++) {
			int j = a + ((int) map.get("pageSize"));
			a = j;
			int k = b + ((int) map.get("pageSize"));
			b = k;
		}
		
		map.put("startNum", b);
		map.put("endNum", a);

		return commentDao.retrieveAllByBookIdForPasing(map);
	}
}
