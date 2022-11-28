package project_MJ.summer.dto;

import lombok.*;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ResponseUserDto {

    private String username;
    private String identity;
    private List<String> roles;
}
