package project_MJ.summer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project_MJ.summer.domain.LectureRoom;
import project_MJ.summer.domain.Locations;
import project_MJ.summer.domain.Users;
import project_MJ.summer.repository.LectureRoomRepo;
import project_MJ.summer.repository.LocationRepo;
import project_MJ.summer.repository.UserRepo;

import java.util.List;

@Service @RequiredArgsConstructor @Slf4j @Transactional
public class LocationServiceImpl implements LocationService {
    private final LocationRepo locationRepo;
    private final UserRepo userRepo;
    private final LectureRoomRepo lectureRoomRepo;
    @Override
    public Users saveUser(Users users) {
        log.info("{} {} {} {}",users.getName(),users.getUsername(),users.getIdentity(),users.getPw());
        return userRepo.save(users);
    }

    @Override
    public Users getUser(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public void addLectToUser(String username,String name) {
        Users users = userRepo.findByName(username);
        users.setLect(name);
        LectureRoom lectureRoom = new LectureRoom();
        lectureRoom.setSearch(name);
        //List<Locations> locations =  locationRepo.findByLocationsList(name);
       // for(int i=0;i<locations.size();i++){
        //    log.info("{}",locations.get(i).toString());
       // }


        //LectureRoom lectureRoom = lectureRoomRepo.findByLect(location);
        //Locations locations = locationRepo.findByOrderByList(location).get();
        //log.info("{}",locationRepo.findByOrderByList(location).get());
        //lectureRoom.getLocations().add(locations);
       // users.getLectureRooms().add(lectureRoom);

    }

    @Override
    public void setLectToLocation(String username, String locationname) {
      Users users = userRepo.findByName(username);
      LectureRoom lectureRoom = new LectureRoom();


    }

    @Override
    public LectureRoom saveLectRoom(LectureRoom lectureRoom) {
        return lectureRoomRepo.save(lectureRoom); // DB Query
    }


    @Override
    public Locations saveLocation(Locations locations) {
        log.info("ID : {} Location : {} X : {} Y : {}",locations.getId(),locations.getList(),locations.getX(),locations.getY());
        return locationRepo.save(locations);
    }
    @Override
    public Locations getLocation(String name) {
        return null;
    }

    @Override
    public List<Locations> getLocations() {
        return locationRepo.findAll();
    }

}
