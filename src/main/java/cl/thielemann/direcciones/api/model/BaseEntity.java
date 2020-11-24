package cl.thielemann.direcciones.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(String id) {
        try {
            this.id = Long.valueOf(id);
        } catch (NumberFormatException ex) {
            this.id = null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Getter
    @Setter
    @Size(min = 1, max = 255, message = "Nombre debe tener desde 1 a 255 caracteres.")
    private String name;
    @Getter
    @Setter
    @NotNull(message = "Debes indicar el estado.")
    private Boolean status;

    public Long getId() {
        if (id != null) {
            return id;
        }
        return 0L;
    }
}
