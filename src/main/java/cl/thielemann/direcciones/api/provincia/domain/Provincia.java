package cl.thielemann.direcciones.api.provincia.domain;

import cl.thielemann.direcciones.api.comuna.domain.Comuna;
import cl.thielemann.direcciones.api.region.domain.Region;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "PROVINCIA")
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Provincia implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION")
    private Region region;
    @OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Comuna> comunas;
    private Boolean status;
}
