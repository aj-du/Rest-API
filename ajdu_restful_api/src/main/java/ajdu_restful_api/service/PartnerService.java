package ajdu_restful_api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ajdu_restful_api.dao.PartnerRepository;
import ajdu_restful_api.model.Partner;

@Service
@Transactional
public class PartnerService {

	private final PartnerRepository partnerRepo;

	public PartnerService(PartnerRepository partnerRepo) {
		super();
		this.partnerRepo = partnerRepo;
	}
	
	public List<Partner> findAll(){
		List<Partner> partners = new ArrayList<Partner>();
		for(Partner partner : partnerRepo.findAll()) {
			partners.add(partner);
		}
		return partners;
	}
	
	public Partner findUser(int id){
		return partnerRepo.findOne(id);
	}
	
	
	public void save(Partner partner) {
		partnerRepo.save(partner);
	}
	
	public void delete(int id) {
		partnerRepo.delete(id);
	}

}
