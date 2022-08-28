package project_MJ.summer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import project_MJ.summer.domain.Locations;

import project_MJ.summer.dto.SearchToPlaceDto;

import project_MJ.summer.repository.LocationRepo;

import java.util.Optional;


@Service @RequiredArgsConstructor @Slf4j
public class LocationService {

    private final LocationRepo locationRepo;

    //가야할 위치 조회
    public SearchToPlaceDto searchToPlaceDto(String place){
        Optional<Locations> locations = locationRepo.findByPlaceLike(place);
        locations.orElseThrow(() ->{
            log.info("조회된 장소가 없습니다.");
            return new RuntimeException("해당 장소가 없습니다.");
        });
        SearchToPlaceDto dto = SearchToPlaceDto
                .builder()
                .place(locations.get().getPlace())
                .x(locations.get().getX())
                .y(locations.get().getY())
                .build();
        log.info("조회된 장소 : {} X : {} Y : {}",dto.getPlace(),dto.getX(),dto.getY());
        return dto;
    }

    //위치 저장
    public Locations addToPlace(Locations locations){
        log.info("장소 : {} X : {} Y : {}",locations.getPlace(),locations.getX(),locations.getY());
        return locationRepo.save(locations);
    }
}
