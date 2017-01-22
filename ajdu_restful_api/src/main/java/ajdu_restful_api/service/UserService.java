package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ajdu_restful_api.dao.UserRepository;
import ajdu_restful_api.model.User;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		for(User user : userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	public User findUser(int id){
		return userRepository.findOne(id);
	}
	
	public User findUserByLogin(String login) {
		return userRepository.findUserByLogin(login);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void delete(int id) {
		userRepository.delete(id);
	}

}
