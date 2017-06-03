
package ajdu_restful_api.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ajdu_restful_api.dao.MediaRepository;
import ajdu_restful_api.model.Media;

@Service
@Transactional
public class MediaService {

	private final MediaRepository mediaRepository;
	
	public MediaService(MediaRepository mediaRepository) {
		super();
		this.mediaRepository = mediaRepository;
	}
	
	public Media findMedia(int id) {
		return mediaRepository.findOne(id);
	}
	
	public List<Media> findAll(){
		return (List<Media>)mediaRepository.findAll();
	}
	
	public void saveMedia(Media media) {
		mediaRepository.save(media);
	}
	
	public void deleteMedia(int id) {
		mediaRepository.delete(id);
	}
	
}
