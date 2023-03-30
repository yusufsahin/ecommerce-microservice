package net.provera.categoryservice;

import org.springframework.boot.SpringApplication;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CategoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryserviceApplication.class, args);
	}
	@Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
