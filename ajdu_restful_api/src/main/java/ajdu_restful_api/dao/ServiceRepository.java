package ajdu_restful_api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Service;

public interface ServiceRepository extends CrudRepository<Service, Integer>{
	public Service findServiceByName(String name);
	public List<Service> findDistinctByCategoriesIdIn(List<Integer> cat);
}
