package pl.sienkiewicz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sienkiewicz.api.MovieRepository;
import pl.sienkiewicz.api.PageService;
import pl.sienkiewicz.dto.MovieDTO;

@Service
public class PageServiceImpl  implements PageService {
	
	private MovieRepository movieRepository;
	
	@Autowired
	public PageServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<MovieDTO> changePage(String category, Integer page) {
		List<MovieDTO> movieList = movieRepository.getMoviesByCategory(category);
		
		if(page*5-5>movieList.size()-1) {
			return movieList.subList(movieList.size()-movieList.size()/5, movieList.size());
		}
		if(page*5>movieList.size()-1) {
			return  movieList.subList(page*5-5, movieList.size());
		}else {
			return movieList.subList(page*5-5, page*5);
		}
	}

}
