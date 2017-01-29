package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ajdu_restful_api.dao.RoleRepository;
import ajdu_restful_api.model.Role;

@Service
@Transactional
public class RoleService {

	private final RoleRepository roleRepo;
	
	public RoleService(RoleRepository roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}
	
	public List<Role> findAllRoles(){
		List<Role> roles = new ArrayList<Role>();
		for(Role role : roleRepo.findAll()) {
			roles.add(role);
		}
		return roles;
	}
	
	public Role findRole(int id) {
		return roleRepo.findOne(id);
	}
	
	public void deleteRole(int id) {
		 roleRepo.delete(id);
	}
	
	public void addRole(Role role) {
		roleRepo.save(role);
	}
	
}
