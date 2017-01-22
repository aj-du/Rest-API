package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Address;
import ajdu_restful_api.model.Organization;

public interface AddressRepository extends CrudRepository<Address, Integer>{

	public Address findAddressByOrganization(Organization org);
	
}
