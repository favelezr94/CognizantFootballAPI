package co.com.favelezr.h2.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table("TEAM")
public class TeamData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    private String owner;
    @Column(name = "stadium_capacity")
    private String stadiumCapacity;
    private String tier;
    private String competition;
    @Column(name = "player_number")
    private int playerNumber;
    @Column(name = "creation_date")
    private LocalDate creationDate;
}
