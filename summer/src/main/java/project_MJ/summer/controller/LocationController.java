package project_MJ.summer.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_MJ.summer.dto.SearchToPlaceDto;
import project_MJ.summer.service.LocationService;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/main")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping("/lectureroom/get")
    @ApiOperation("해당 계정으로 가야할 곳 조회")
    public ResponseEntity searchToPlaceDto(@RequestParam("search")String place){
        try{
            SearchToPlaceDto searchToPlaceDto = locationService.searchToPlaceDto(place);
            return new ResponseEntity(searchToPlaceDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("등록된 장소명이 아닙니다.", HttpStatus.BAD_REQUEST);
        }
    }

}
