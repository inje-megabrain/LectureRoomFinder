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
			locationServiceimpl.saveUser(new Users(null,"문상원","MOON","kuim75","1234",new ArrayList<>(),null));

			locationServiceimpl.saveLectRoom(new LectureRoom(null,"13","15","A동",new ArrayList<>()));

			List<String> place1 = new ArrayList<>();
			place1.add("A동");
			place1.add("하연관");

			List<String> place2 = new ArrayList<>();
			place2.add("B동");
			place2.add("창조관");
			List<String> place3 = new ArrayList<>();
			place3.add("C동");
			place3.add("신어관");

			locationServiceimpl.saveLocation(new Locations(1L, place1,"35.247429","128.902785"));
			locationServiceimpl.saveLocation(new Locations(2L, place2,"35.248505","128.903846"));
			locationServiceimpl.saveLocation(new Locations(3L, place3,"35.249394","128.903272"));

			//locationServiceimpl.addLectToUser("문상원","A동");
		};
	}
}
