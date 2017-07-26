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
	
	public void savePartial(Service service, Integer id) {
		Service newService = findService(id);
		if(service.getCategories() != null) newService.setCategories(service.getCategories());
		if(service.getCost() != null) newService.setCost(service.getCost());
		if(service.getName() != null) newService.setName(service.getName());
		if(service.getDescription() != null) newService.setDescription(service.getDescription());
		if(service.getMedia() != null) newService.setMedia(service.getMedia());
		if(service.isDistinct() != null) newService.setDistinct(service.isDistinct());
		serviceRepository.save(newService);
	}
	
	public void deleteService(int id) {
		serviceRepository.delete(id);
	}
	
	public List<Service> findByCategoryId(List<Integer> catIds) {
		return (List<Service>)serviceRepository.findDistinctByCategoriesIdIn(catIds);
	}
	
}
