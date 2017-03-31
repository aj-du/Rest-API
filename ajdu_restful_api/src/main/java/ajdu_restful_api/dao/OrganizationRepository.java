package ajdu_restful_api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Integer>{
	public Organization findOrganizationByLogin(String login);
	public List<Organization> findDistinctByCategoriesIdIn(List<Integer> cat);
}
