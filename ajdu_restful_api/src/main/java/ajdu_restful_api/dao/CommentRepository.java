package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
