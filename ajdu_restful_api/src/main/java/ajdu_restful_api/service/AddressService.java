package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.AddressRepository;
import ajdu_restful_api.model.Address;
import ajdu_restful_api.model.Organization;

@Service
@Transactional
public class AddressService {

	private final AddressRepository addressRepo;
	
	public AddressService(AddressRepository addressRepository) {
		super();
		this.addressRepo = addressRepository;
	}
	
	
	public List<Address> findAllAddresses(){
		List<Address> addresses = new ArrayList<Address>();
		for(Address a : addressRepo.findAll()) {
			addresses.add(a);
		}
		return addresses;
	}

	public Address findOneAddress(int id){
		return addressRepo.findOne(id);
	}
	
	public Address findAddressByOrganization(Organization org) {
		return addressRepo.findAddressByOrganization(org);
	}
	
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}
	
	public void deleteAddress(int id) {
		addressRepo.delete(id);
	}
	
}
