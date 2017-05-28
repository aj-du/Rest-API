
package ajdu_restful_api.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.CommentRepository;
import ajdu_restful_api.model.Comment;

@Service
@Transactional
public class CommentService {

	private final CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}
	
	public Comment findComment(int id) {
		return commentRepository.findOne(id);
	}
	
	public List<Comment> findAll(){
		return (List<Comment>)commentRepository.findAll();
	}
	
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void deleteComment(int id) {
		commentRepository.delete(id);
	}
	
}
