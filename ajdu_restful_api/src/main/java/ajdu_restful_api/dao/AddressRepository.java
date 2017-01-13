package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
