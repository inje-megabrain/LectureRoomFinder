package project_MJ.summer.service;

import project_MJ.summer.domain.Locations;

import java.util.List;

public interface LocationServiceImpl {
    Locations saveLocation(Locations locations);
    Locations getLocation(String name);
    List<Locations>getLocations();
}
