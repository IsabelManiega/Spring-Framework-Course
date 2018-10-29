package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsadeideas.springboot.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{

	@Autowired
	IUploadFileService uploadFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	
/*Sirve para borrar todas las imagenes de la sesión anterior*/
	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
		
	}
}
