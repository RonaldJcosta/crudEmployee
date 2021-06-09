package br.com.ronald.api;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;



public class Servidor {
	
	public static void main(String[] args) {
		
		try {
			
			URI uri = UriBuilder.fromUri("http://localhost").port(8080).build();
			ResourceConfig config = new ResourceConfig();
			config.register(JacksonFeature.class);
			config.packages("br.com.ronald.api");
			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
			
			System.out.println("Server is running " + server );
			
		} catch (Exception e) {
			System.out.println("Erro na execução do servidor jse - " + e.getMessage());
		}
		
	}
}
	

	

