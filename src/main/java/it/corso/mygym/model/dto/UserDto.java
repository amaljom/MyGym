package it.corso.mygym.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private LocalDate dateOfBirth;

    private Boolean certification;


    private Boolean activated = true;

    private Boolean activateFlag = true;
}
