package ajdu_restful_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import ajdu_restful_api.dao.ServiceRepository;
import ajdu_restful_api.model.Service;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService {

	private final ServiceRepository serviceRepository;
	
	@Autowired
	private PackageService packageService;
	
	public ServiceService(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}
	
	public Service findService(int id) {
		return serviceRepository.findOne(id);
	}
	
	public List<Service> findAllServicesByPackage(@RequestParam int packageId){
		return packageService.findPackage(packageId).getServices();
	}
	
	public Service findServiceByName(String name) {
		return serviceRepository.findServiceByName(name);
	}
	
	public List<Service> findAll(){
		return (List<Service>)serviceRepository.findAll();
	}
	
	public void saveService(Service service) {
		serviceRepository.save(service);
	}
	
	public void deleteService(int id) {
		serviceRepository.delete(id);
	}
	
}
