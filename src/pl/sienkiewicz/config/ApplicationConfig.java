package pl.sienkiewicz.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@ComponentScan({ "pl.sienkiewicz.controllers", "pl.sienkiewicz.services", "pl.sienkiewicz.dao" })
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {
	
	@Autowired
	private RequestMappingHandlerAdapter requestHandlerMappingAdapter;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/", ".jsp");
	}
	
	@PostConstruct
	public void init() {
		requestHandlerMappingAdapter.setIgnoreDefaultModelOnRedirect(true);
	}

}
