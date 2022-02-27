package co.com.favelezr.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class Team {
    private String name;
    private String city;
    private String owner;
    private int stadiumCapacity;
    private String tier;
    private String competition;
    private int playerNumber;
    private LocalDate creationDate;
}
