package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{

}
