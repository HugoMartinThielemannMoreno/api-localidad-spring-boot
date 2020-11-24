package cl.thielemann.direcciones.api.comuna;

import java.util.List;

public interface ComunaService {
    Comuna createOrUpdate(Comuna comuna);

    Comuna findById(Long id);

    List<Comuna> findAll();

    void deleteById(Long id);
}
