package cl.thielemann.direcciones.api.provincia.domain;

import java.util.List;
import java.util.UUID;

public interface ProvinciaService {

    Provincia createOrUpdate(Provincia provincia);

    Provincia findById(UUID uuid);

    List<Provincia> findAll();

    void deleteById(UUID uuid);


}
