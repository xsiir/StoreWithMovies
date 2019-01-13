package pl.sienkiewicz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.sienkiewicz.api.CurrencyConverter;
import pl.sienkiewicz.api.MovieRepository;
import pl.sienkiewicz.api.ShoppingCart;
import pl.sienkiewicz.dto.MovieDTO;

@Controller
@RequestMapping("/")
public class HomeController {

	private CurrencyConverter currencyConverter;
	private MovieRepository  movieRepository;
	private ShoppingCart shoppingCart;

	@Autowired
	public HomeController(CurrencyConverter currencyConverter, MovieRepository movieRepository, ShoppingCart shoppingCart) {
		this.currencyConverter = currencyConverter;
		this.movieRepository = movieRepository;
		this.shoppingCart = shoppingCart;
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView getMovies(@RequestParam(name = "category", required = false, defaultValue = "ANY") String category) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("movieList", movieRepository.getMoviesByCategory(category));
		model.addObject("shoppingCart", shoppingCart);
		return model;
	}
	
	
	//W TRAKCIE
	@RequestMapping(value = "/sz", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute("movie") Integer movieId) {
		shoppingCart.addProduct(movieRepository.getMovieById(movieId));
		System.out.println(shoppingCart.getAllProducts().get(0).getTitle());
		return "redirect:/StoreWithMovies";
		
	}
}
