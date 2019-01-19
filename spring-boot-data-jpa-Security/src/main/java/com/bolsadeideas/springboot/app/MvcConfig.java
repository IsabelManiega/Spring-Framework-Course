package com.bolsadeideas.springboot.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/* En SpringBoot 2.0 se cambia el WebMvcConfiguationAdapter por WebMvcConfigurer.*/

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*private final Logger log = LoggerFactory.getLogger(getClass());
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		

		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		log.info(resourcePath);
		
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(resourcePath);
	}*/
		
}
