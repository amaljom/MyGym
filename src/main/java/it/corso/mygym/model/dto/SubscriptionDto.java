package it.corso.mygym.model.dto;

import it.corso.mygym.model.enums.Type;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private int price;
    private Boolean isPayed;

    private Type type;
}
