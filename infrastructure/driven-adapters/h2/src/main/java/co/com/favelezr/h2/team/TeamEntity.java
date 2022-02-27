package co.com.favelezr.h2.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("TEAM")
public class TeamEntity implements Persistable<String> {
    @Id
    private String name;
    private String city;
    private String owner;
    @Column(name = "stadium_capacity")
    private int stadiumCapacity;
    private String tier;
    private String competition;
    @Column(name = "player_number")
    private int playerNumber;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Transient
    @Setter
    private boolean isNew;

    @Override
    public String getId() {
        return name;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
