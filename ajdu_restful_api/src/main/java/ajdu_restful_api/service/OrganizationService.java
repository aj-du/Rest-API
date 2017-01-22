package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.OrganizationRepository;
import ajdu_restful_api.model.Organization;

@Service
@Transactional
public class OrganizationService {

	private final OrganizationRepository organizationRepository;
	
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
	
	public Organization findOneOrg(int id) {
		return organizationRepository.findOne(id);
	}
	
	public Organization findOrgByLogin(String login) {
		return organizationRepository.findOrganizationByLogin(login);
	}
	
	public void saveOrg(Organization org) {
		organizationRepository.save(org);
	}
	
	public void deleteOrg(int id) {
		organizationRepository.delete(id);
	}
	
}
