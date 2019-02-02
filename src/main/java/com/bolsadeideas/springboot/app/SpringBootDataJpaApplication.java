package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bolsadeideas.springboot.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{

	@Autowired
	IUploadFileService uploadFileService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	
/*Sirve para borrar todas las imagenes de la sesión anterior*/
	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
		
		String password1 = "12345";/*Roles_User*/
		String password2 = "abcde";/*Role_Admin*/
		
		String bcryptPassword1 = passwordEncoder.encode(password1);
		System.out.println(bcryptPassword1);
		
		String bcryptPassword2 = passwordEncoder.encode(password2);
		System.out.println(bcryptPassword2);
		
		/*Esto sería si tuvieramos una única contraseña para los dos roles, pero yo tengo dos separadas 
		 * for (int i = 0; i < 2; i ++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
			
		}*/
		
	}
}
