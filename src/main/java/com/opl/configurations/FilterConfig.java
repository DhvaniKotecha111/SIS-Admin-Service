package com.opl.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.opl.filters.JwtFilter;

@Configuration
public class FilterConfig {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public FilterRegistrationBean jwtFilterRegistration() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new JwtFilter(restTemplate));
		filter.addUrlPatterns("/*");
		return filter;
	}
}
