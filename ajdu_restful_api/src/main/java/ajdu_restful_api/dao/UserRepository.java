package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
