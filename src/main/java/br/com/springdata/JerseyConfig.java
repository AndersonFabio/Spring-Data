package br.com.springdata;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.springdata.api.CustomerApi;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CustomerApi.class);
	}
	
}
