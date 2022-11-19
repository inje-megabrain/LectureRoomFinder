package project_MJ.summer.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_MJ.summer.dto.GetAllplaceDto;
import project_MJ.summer.dto.ResponseUserDto;
import project_MJ.summer.dto.SearchToPlaceDto;
import project_MJ.summer.service.LocationService;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping("/lect/find")
    @ApiOperation("가야할 곳 조회")
    public ResponseEntity searchToPlaceDto(@RequestParam("search")String place){
        try{
            SearchToPlaceDto searchToPlaceDto = locationService.searchToPlaceDto(place);
            return new ResponseEntity(searchToPlaceDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("등록된 장소명이 아닙니다.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/lect/all")
    @ApiOperation("전체 위치 조회")
    public ResponseEntity getAllplace(){
        try {
            List<GetAllplaceDto> get = locationService.getAllPlace();
            return new ResponseEntity(get, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("잘못된 조회", HttpStatus.BAD_REQUEST);
        }
    }
}
