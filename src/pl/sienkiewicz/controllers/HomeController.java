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

@Controller
@RequestMapping("/")
public class HomeController {

	private final CurrencyConverter currencyConverter;
	private final MovieRepository movieRepository;
	private final ShoppingCart shoppingCart;

	@Autowired
	public HomeController(CurrencyConverter currencyConverter, MovieRepository movieRepository,
			ShoppingCart shoppingCart) {
		this.currencyConverter = currencyConverter;
		this.movieRepository = movieRepository;
		this.shoppingCart = shoppingCart;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getMovies(
			@RequestParam(name = "category", required = false, defaultValue = "ANY") String category,
			@RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("movieList", movieRepository.getMoviesWithPagination(category, pageNumber));
		model.addObject("selectedCategory", category);
		model.addObject("shoppingCart", shoppingCart);
		model.addObject("converter", currencyConverter);
		model.addObject("currentPage", pageNumber);
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute("movie") Integer movieId,
			@RequestParam("currentCategory") String currentCategory,
			@RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber) {
		shoppingCart.addProduct(movieRepository.getMovieById(movieId));
		return "redirect:?category=" + currentCategory + "&page=" + pageNumber;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@ModelAttribute("movie") Integer movieId,  @RequestParam("currentCategory")  String currentCategory, @RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber) {
		shoppingCart.removeProduct(movieRepository.getMovieById(movieId));
		return "redirect:.?category="+currentCategory+"&page="+pageNumber;
	}

	@RequestMapping(value = "/previousPage",  method =  RequestMethod.POST)
	public String previousPage(@RequestParam("currentCategory")  String currentCategory, @RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber){
		if(pageNumber>1) {pageNumber--;}
		return "redirect:.?category="+currentCategory+"&page="+pageNumber;
	}
	
	@RequestMapping(value = "/nextPage",  method =  RequestMethod.POST)
	public String nextPage(@RequestParam("currentCategory")  String currentCategory, @RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber){
		pageNumber++;
		return "redirect:.?category="+currentCategory+"&page="+pageNumber;
	}
}
