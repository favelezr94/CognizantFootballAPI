package co.com.favelezr.h2.team;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class TeamData {
    @Id
    private UUID id;
    private String name;
    private String city;
    private String owner;
    private String stadiumCapacity;
    private String tier;
    private String competition;
    private int playerNumber;
    private LocalDate creationDate;
}
