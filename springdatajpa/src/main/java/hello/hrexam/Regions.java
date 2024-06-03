package hello.hrexam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Regions {
    @Id
    @Column(name = "region_id", nullable = false)
    private Integer regionId;

    @Column(name = "region_name")
    private String regionName;
}
