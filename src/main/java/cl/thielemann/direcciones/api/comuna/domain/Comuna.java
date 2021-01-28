package cl.thielemann.direcciones.api.comuna.domain;

import cl.thielemann.direcciones.api.provincia.domain.Provincia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
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
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Una entidad
 *
 * @author hmtm
 */

@Entity
@Table(name = "COMUNA")
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comuna implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCIA")
    private Provincia provincia;
    private Boolean status;
}
