package project_MJ.summer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project_MJ.summer.domain.Locations;
import project_MJ.summer.service.LocationService;
import project_MJ.summer.service.LocationServiceImpl;

@SpringBootApplication
public class SummerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SummerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(LocationServiceImpl locationServiceimpl){
		return args ->{
			locationServiceimpl.saveLocation(new Locations(null,"A동","35.247429","128.902785"));
			locationServiceimpl.saveLocation(new Locations(null,"B동","35.248505","128.903846"));
			locationServiceimpl.saveLocation(new Locations(null,"C동","35.249394","128.903272"));
		};
	}
}
