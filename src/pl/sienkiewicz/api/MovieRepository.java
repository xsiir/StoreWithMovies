package pl.sienkiewicz.api;

import java.util.List;

import pl.sienkiewicz.dto.MovieDTO;

public interface MovieRepository {
	
	List<MovieDTO> getMovies();
	List<MovieDTO> getMoviesByCategory(String category);
	MovieDTO getMovieById(Integer id);

}
