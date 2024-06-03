package hello.hrexam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Countries {
    @Id
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "region_id")
    private Integer regionId;
}
