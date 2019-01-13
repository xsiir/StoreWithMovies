package pl.sienkiewicz.api;

import java.util.List;

import pl.sienkiewicz.dto.MovieDTO;

public interface ShoppingCart {
	
	boolean addProduct(MovieDTO movie);
	boolean removeProduct(MovieDTO  movie);
	double getPriceOfCartProducts();
	List<MovieDTO> getAllProducts();
	
}
