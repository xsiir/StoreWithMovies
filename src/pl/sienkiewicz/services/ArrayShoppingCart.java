package pl.sienkiewicz.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import pl.sienkiewicz.api.ShoppingCart;
import pl.sienkiewicz.dto.MovieDTO;

@Service
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ArrayShoppingCart implements ShoppingCart {

	private ArrayList<MovieDTO> cart = new ArrayList<>();

	@Override
	public boolean addProduct(MovieDTO movie) {
		if (cart.add(movie))
			return true;
		return false;
	}

	@Override
	public boolean removeProduct(MovieDTO movie) {
		if (cart.remove(movie))
			return true;
		return false;
	}

	@Override
	public double getPriceOfCartProducts() {
		double price = 0;
		for (MovieDTO movie : cart) {
			price += movie.getPrice();
		}
		return price;
	}

	@Override
	public List<MovieDTO> getAllProducts() {
		return cart;
	}

}
