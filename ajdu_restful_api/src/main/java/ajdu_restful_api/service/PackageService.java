package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.PackageRepository;
import ajdu_restful_api.model.Package;
import ajdu_restful_api.model.User;

@Transactional
@Service
public class PackageService {
	
	private final PackageRepository packageRepository;
	

	public PackageService(PackageRepository packageRepository) {
		super();
		this.packageRepository = packageRepository;
	}
	
	public List<Package> findPackages(){
		List<Package> packages = new ArrayList<Package>();
		for(Package p: packageRepository.findAll())
			packages.add(p);
		return packages;
	}
	
	public Package findPackage(int id){
		return packageRepository.findOne(id);
	}
	
	public Package findPackageByUser(User user){
		return packageRepository.findPackageByUser(user);
	}
	
	public void save(Package p) {
		packageRepository.save(p);
	}
	
	public void delete(int id) {
		packageRepository.delete(id);
	}
	
}
