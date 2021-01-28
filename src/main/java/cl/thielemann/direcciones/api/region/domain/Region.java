package cl.thielemann.direcciones.api.region.domain;

import cl.thielemann.direcciones.api.provincia.domain.Provincia;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "REGION")
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Region implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Provincia> provincias;
    private Boolean status;
}
