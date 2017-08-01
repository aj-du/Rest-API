package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajdu_restful_api.dao.UserRepository;
import ajdu_restful_api.model.Partner;
import ajdu_restful_api.model.User;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	PartnerService partnerService;

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
		user.setActive(true);
		userRepository.save(user);
	}
	
	public void savePartial(User user, Integer id) {
		User newUser = findUser(id);
		Partner partner;
		if(user.getFirstName() != null) newUser.setFirstName(user.getFirstName());
		if(user.getLastName() != null) newUser.setLastName(user.getLastName());
		if(user.getEmail() != null) newUser.setEmail(user.getEmail());;
		if(user.getLogin() != null && findUserByLogin(user.getLogin()) == null) newUser.setLogin(user.getLogin());
		if(user.getPartner() != null) {
			partner = newUser.getPartner();
			if(partner == null) partner = new Partner();
			if(user.getPartner().getFirstName() != null) partner.setFirstName(user.getPartner().getFirstName());
			if(user.getPartner().getLastName() != null) partner.setLastName(user.getPartner().getLastName());;
			if(user.getPartner().getGender() != null) partner.setGender(user.getPartner().getGender());
			partnerService.save(partner);
		}
		if(user.isActive() != null) newUser.setActive(user.isActive());
		if(user.getPassword() != null) newUser.setPassword(user.getPassword());
		if(user.getRoles() != null) newUser.setRoles(user.getRoles());
		userRepository.save(newUser);
	}
	
	public void delete(int id) {
		userRepository.delete(id);
	}

}
