package com.index;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration // -> is enough to have a configuration file.

public class MVC_Config extends WebMvcConfigurerAdapter {
	// To make it a WEB configuration file -> WebMvcConfigurerAdapter
	// to the configuration based on Spring MVC, similar to @EnableMVC

	// It offers some methods to overwrite , like ...

	@Override // This method allows to associate Views with URLs
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/land").setViewName("landing");
		// if something call land go to landing

		// registry.addViewController("/login").setViewName("hi");
	}
}
