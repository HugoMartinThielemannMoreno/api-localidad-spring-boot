package cl.thielemann.direcciones.api.provincia;

import cl.thielemann.direcciones.api.comuna.Comuna;
import cl.thielemann.direcciones.api.model.BaseEntity;
import cl.thielemann.direcciones.api.region.Region;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "PROVINCIA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Provincia extends BaseEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "REGION")
    private Region region;
    @OneToMany(mappedBy = "provincia")
    @JsonManagedReference
    private Set<Comuna> comunas;
}
