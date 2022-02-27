package co.com.favelezr.api.team.validator;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class TeamDTO {
    @NotNull
    @NotBlank
    private String name;
    private String city;
    private String owner;
    @Positive
    private int stadiumCapacity;
    @Pattern(regexp = "[1-3]")
    private String tier;
    private String competition;
    @Positive
    private int playerNumber;
    @Past
    private LocalDate creationDate;
}
