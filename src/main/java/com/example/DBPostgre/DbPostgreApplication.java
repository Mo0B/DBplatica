package com.example.DBPostgre;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbPostgreApplication {

	public static void main(String[] args) {
		CargarEnv();
		SpringApplication.run(DbPostgreApplication.class, args);
	}

	//CARGAR LAS VARIABLES DE ENTORNO
	private static void CargarEnv(){
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
	}
}
