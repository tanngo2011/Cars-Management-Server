package com.example.CarShop;

import com.example.CarShop.entity.Role;
import com.example.CarShop.entity.User;
import com.example.CarShop.repository.RoleRepository;
import com.example.CarShop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
@AllArgsConstructor
@SpringBootApplication
public class CarShopApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CarShopApplication.class, args);
	}

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Role admin = roleRepository.findByType(Role.Type.ADMIN);
		Role user = roleRepository.findByType(Role.Type.USER);

		User account1 = new User();
		account1.setFullname("Sherlock Holmes");
		account1.setUsername("haha");
		account1.setPassword(passwordEncoder.encode("123456"));
		account1.setRoles(Set.of(admin, user));
		userRepository.save(account1);

		User account2 = new User();
		account2.setFullname("Hoàng Mai Thảo");
		account2.setUsername("hoho");
		account2.setPassword(passwordEncoder.encode("thao123"));
		account2.setRoles(Set.of(user));
		userRepository.save(account2);

		User account3 = new User();
		account3.setFullname("Ngô Mạnh Tân");
		account3.setUsername("hihi");
		account3.setPassword(passwordEncoder.encode("tan123"));
		account3.setRoles(Set.of(user));
		userRepository.save(account3);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
