package com.franquicia.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication // se encarga de que el servidor arranque de manera correcta 
@EnableDiscoveryClient //Permite que el Gateway se conecte a un servidor de descubrimiento como EUREKA
//para encontrar automáticamente dónde están los otros servicios de tu sistema sin tener que escribir sus direcciones IP a mano.
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
