
package ajdu_restful_api.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.OpinionRepository;
import ajdu_restful_api.model.Opinion;

@Service
@Transactional
public class OpinionService {

	private final OpinionRepository opinionRepository;
	
	public OpinionService(OpinionRepository opinionRepository) {
		super();
		this.opinionRepository = opinionRepository;
	}
	
	public Opinion findOpinion(int id) {
		return opinionRepository.findOne(id);
	}
	
	public List<Opinion> findAll(){
		return (List<Opinion>)opinionRepository.findAll();
	}
	
	public void saveOpinion(Opinion opinion) {
		opinionRepository.save(opinion);
	}
	
	public void deleteOpinion(int id) {
		opinionRepository.delete(id);
	}
	
}
