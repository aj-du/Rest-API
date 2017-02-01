package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Package;
import ajdu_restful_api.model.User;

public interface PackageRepository extends CrudRepository<Package, Integer>{
	public Package findPackageByUser(User user);
}
