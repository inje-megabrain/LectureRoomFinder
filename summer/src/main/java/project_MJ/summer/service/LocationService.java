package project_MJ.summer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_MJ.summer.domain.Locations;
import project_MJ.summer.repository.LocationRepo;

import java.util.List;

@Service @RequiredArgsConstructor @Slf4j

public class LocationService implements LocationServiceImpl{
    private final LocationRepo locationRepo;
    @Override
    public Locations saveLocation(Locations locations) {
        log.info("{} {} {}",locations.getName(),locations.getX(),locations.getY());
        return locationRepo.save(locations);
    }
    @Override
    public Locations getLocation(String name) {
        return locationRepo.findByName(name);
    }

    @Override
    public List<Locations> getLocations() {
        return locationRepo.findAll();
    }
}
