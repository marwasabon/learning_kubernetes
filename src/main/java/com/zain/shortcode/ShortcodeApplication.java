package com.zain.shortcode;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 
 * @author m.sabon
 *
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
@EnableAsync
@EnableScheduling
@Configuration
public class ShortcodeApplication {
	

	@Bean
	public ModelMapper modelMapper(){
		
		return new ModelMapper();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ShortcodeApplication.class, args);
	
	}
	

}
