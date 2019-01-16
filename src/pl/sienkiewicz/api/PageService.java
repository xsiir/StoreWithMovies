package pl.sienkiewicz.api;

import java.util.List;

import pl.sienkiewicz.dto.MovieDTO;

public interface PageService {
	
	List<MovieDTO> changePage(String category, Integer page);

}
