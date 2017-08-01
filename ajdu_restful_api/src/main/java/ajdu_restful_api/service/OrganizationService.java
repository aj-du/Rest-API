package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.OrganizationRepository;
import ajdu_restful_api.model.Address;
import ajdu_restful_api.model.Organization;

@Service
@Transactional
public class OrganizationService {

	private final OrganizationRepository organizationRepository;
	
	@Autowired
	AddressService addressService;
	
	public OrganizationService(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}
	
	public List<Organization> findAllOrgs() {
		List<Organization> orgs = new ArrayList<Organization>();
		for(Organization org : organizationRepository.findAll()) {
			orgs.add(org);
		}
		return orgs;
	}
	
	public List<Organization> findByCategoryId(List<Integer> catIds) {
		return (List<Organization>)organizationRepository.findDistinctByCategoriesIdIn(catIds);
	}
	
	public List<Organization> findByCity(String city) {
		return (List<Organization>)organizationRepository.findByAddressCityIgnoreCase(city);
	}
	
	public Organization findOneOrg(int id) {
		return organizationRepository.findOne(id);
	}
	
	public Organization findOrgByLogin(String login) {
		return organizationRepository.findOrganizationByLogin(login);
	}
	
	public void saveOrg(Organization org) {
		organizationRepository.save(org);
	}
	
	public void saveOrgPartial(Organization org, Integer id) {
		Organization newOrg = findOneOrg(id);
		Address address;
		if(org.getName() != null) newOrg.setName(org.getName());
		if(org.getLogin() != null && findOrgByLogin(org.getLogin()) == null) newOrg.setLogin(org.getLogin());
		if(org.getEmail() != null) newOrg.setEmail(org.getEmail());
		if(org.isActive() != null) newOrg.setActive(org.isActive());
		if(org.getPassword() != null) newOrg.setPassword(org.getPassword());
		if(org.getPhoneNumber() != null) newOrg.setPhoneNumber(org.getPhoneNumber());
		if(org.getCategories() != null) newOrg.setCategories(org.getCategories());
		if(org.getAddress() != null) {
			address = addressService.findOneAddress(newOrg.getAddress().getId());
			if(org.getAddress().getCity() != null) address.setCity(org.getAddress().getCity());
			if(org.getAddress().getLine1() != null) address.setLine1(org.getAddress().getLine1());
			if(org.getAddress().getLine2() != null) address.setLine1(org.getAddress().getLine2());
			if(org.getAddress().getPostalCode() != null) address.setPostalCode(org.getAddress().getPostalCode());
			if(org.getAddress().getRegion() != null) address.setRegion(org.getAddress().getRegion());
			addressService.saveAddress(address);			
		}
		organizationRepository.save(newOrg);
	}
	
	public void deleteOrg(int id) {
		organizationRepository.delete(id);
	}
	
}
