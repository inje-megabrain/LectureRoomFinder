package project_MJ.summer.service;

import project_MJ.summer.domain.LectureRoom;
import project_MJ.summer.domain.Locations;
import project_MJ.summer.domain.Users;

import java.util.List;

public interface LocationService {

    Users saveUser(Users users);
    Users getUser(String name);
    List<Users>getUsers();

    void addLectToUser (String username,String location);
    void setLectToLocation(String username, String place);

    LectureRoom saveLectRoom (LectureRoom lectureRoom);
    Locations saveLocation(Locations locations);
    Locations getLocation(String name);
    List<Locations>getLocations();
}
