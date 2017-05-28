package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Blog;
import ajdu_restful_api.model.User;

public interface BlogRepository extends CrudRepository<Blog, Integer>{
	public Blog findBlogByUser(User user);
}
