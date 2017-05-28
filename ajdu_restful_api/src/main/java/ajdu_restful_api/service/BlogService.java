package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.BlogRepository;
import ajdu_restful_api.model.Blog;
import ajdu_restful_api.model.User;

@Transactional
@Service
public class BlogService {
	
	private final BlogRepository blogRepository;
	

	public BlogService(BlogRepository blogRepository) {
		super();
		this.blogRepository = blogRepository;
	}
	
	public List<Blog> findBlogs(){
		List<Blog> blogs = new ArrayList<Blog>();
		for(Blog p: blogRepository.findAll())
			blogs.add(p);
		return blogs;
	}
	
	public Blog findBlog(int id){
		return blogRepository.findOne(id);
	}
	
	public Blog findBlogByUser(User user){
		return blogRepository.findBlogByUser(user);
	}
	
	public void save(Blog p) {
		blogRepository.save(p);
	}
	
	public void delete(int id) {
		blogRepository.delete(id);
	}
	
}
