package project_MJ.summer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project_MJ.summer.domain.LectureRoom;
import project_MJ.summer.domain.Locations;
import project_MJ.summer.domain.Users;
import project_MJ.summer.service.LocationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SummerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SummerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(LocationService locationServiceimpl){
		return args ->{
			locationServiceimpl.addToPlace(new Locations("A동 하연관","35.247429","128.902785"));
			locationServiceimpl.addToPlace(new Locations("B동 창조관","35.248505","128.903846"));
			locationServiceimpl.addToPlace(new Locations("C동 신어관","35.249394","128.903272"));
		};
	}
}
