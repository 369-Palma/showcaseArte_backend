package com.palma.ecommerceArte.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.palma.ecommerceArte.service.ClientService;
import com.palma.ecommerceArte.service.NewsService;
import com.palma.ecommerceArte.service.ProductService;
import com.palma.ecommerceArte.auth.repository.RoleRepository;
import com.palma.ecommerceArte.auth.repository.UserRepository;
import com.palma.ecommerceArte.auth.service.AuthService;
import com.palma.ecommerceArte.auth.entity.ERole;
import com.palma.ecommerceArte.auth.entity.Role;

@Component @SpringBootApplication(scanBasePackages = "com.palma.ecommerceArte.auth.entity")
public class EccomerceArteRunner implements ApplicationRunner {

	@Autowired ProductService productService;
	@Autowired ClientService clientService;
	@Autowired NewsService newsService;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthService authService;
	
	private static Set<Role> adminRole;
	private static Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//SETTA RUOLI ADMIN/USER IN DB
				//setRoleDefault();
				
				//EFETTUARE LA REGISTRAZIONE E IL LOGIN
				
				//REGISTRARSI QUI TRAMITE ENDPOINT
				//POPOLA IL DB
				//starterDB();
		
	}
	
private void starterDB() {
			productService.giveProduct();
			for(int i = 0; i<3; i++) {
			clientService.createClientRandom();
			}
			newsService.giveNews();
		}

private void setRoleDefault() {
	Role admin = new Role();
	admin.setRoleName(ERole.ROLE_ADMIN);
	roleRepository.save(admin);

	Role user = new Role();
	user.setRoleName(ERole.ROLE_USER);
	roleRepository.save(user);

	adminRole = new HashSet<Role>();
	adminRole.add(admin);
	adminRole.add(user);

	userRole = new HashSet<Role>();
	userRole.add(user);
}
		
}
