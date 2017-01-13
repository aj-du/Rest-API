package ajdu_restful_api.dao;

import org.springframework.data.repository.CrudRepository;

import ajdu_restful_api.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>{

}
