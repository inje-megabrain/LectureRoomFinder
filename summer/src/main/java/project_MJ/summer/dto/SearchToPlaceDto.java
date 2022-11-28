package project_MJ.summer.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class SearchToPlaceDto {

    private String place;
    private String x;
    private String y;
}
