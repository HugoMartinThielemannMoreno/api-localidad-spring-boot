package cl.thielemann.direcciones.api.comuna.domain;

import java.util.List;
import java.util.UUID;

public interface ComunaService {
    Comuna create(Comuna comuna);

    Comuna update(Comuna comuna);

    Comuna findById(UUID id);

    List<Comuna> findAll();

    List<Comuna> findAllByProvincia_id(UUID id);

    void deleteById(UUID id);
}
