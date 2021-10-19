package gram.project.grambook.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {

    @Size(min = 2)
    private String name;

    @Size(min = 5, max = 10)
    private String userId;

    @Size(min = 8, max = 15)
    private String password;
}
