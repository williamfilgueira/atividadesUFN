package br.atos.ufn.SpringAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
		System.out.println("Estou funcionando, mas to lento :(");
		System.out.println("Ainda estou funcionando?");
	}

}
