package com.bolsadeideas.springboot.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* En SpringBoot 2.0 se cambia el WebMvcConfiguationAdapter por WebMvcConfigurer.*/

@Configuration
public class MvcConfig implements WebMvcConfigurer{

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
