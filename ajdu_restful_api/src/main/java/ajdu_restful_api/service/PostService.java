
package ajdu_restful_api.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.PostRepository;
import ajdu_restful_api.model.Post;

@Service
@Transactional
public class PostService {

	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	public Post findPost(int id) {
		return postRepository.findOne(id);
	}
	
	public List<Post> findAll(){
		return (List<Post>)postRepository.findAll();
	}
	
	public void savePost(Post post) {
		postRepository.save(post);
	}
	
	public void deletePost(int id) {
		postRepository.delete(id);
	}
	
}
