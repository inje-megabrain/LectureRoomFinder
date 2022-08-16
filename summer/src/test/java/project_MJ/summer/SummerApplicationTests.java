package project_MJ.summer;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import project_MJ.summer.repository.LectureRoomRepo;
import project_MJ.summer.repository.LocationRepo;
import project_MJ.summer.repository.UserRepo;
import project_MJ.summer.service.LocationService;
import project_MJ.summer.service.LocationServiceImpl;

@TestPropertySource(locations = "/application.properties")
@SpringBootTest
class SummerApplicationTests {

	@Test
	void contextLoads() {

	}
}
