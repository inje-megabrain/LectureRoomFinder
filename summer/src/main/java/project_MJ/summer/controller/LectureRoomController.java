package project_MJ.summer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project_MJ.summer.service.LectureRoomService;

@RestController
@RequestMapping("/api")
public class LectureRoomController {

    private LectureRoomService lectureRoomService;

    @Autowired
    public LectureRoomController(LectureRoomService lectureRoomService) {
        this.lectureRoomService = lectureRoomService;
    }



}
