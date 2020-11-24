package cl.thielemann.direcciones.api.region;

import cl.thielemann.direcciones.api.model.BaseEntity;
import cl.thielemann.direcciones.api.provincia.Provincia;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "REGION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Region extends BaseEntity {
    @OneToMany(mappedBy = "region")
    @JsonManagedReference
    private Set<Provincia> provincias;
}
