package project_MJ.summer.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project_MJ.summer.domain.Locations;
import project_MJ.summer.service.LocationService;
import project_MJ.summer.service.LocationServiceImpl;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class LocationController {
    private final LocationServiceImpl locationServiceimpl;
    @GetMapping("/api")
    public ResponseEntity<List<Locations>> getLocations(){
        return ResponseEntity.ok().body(locationServiceimpl.getLocations());
    }

}
