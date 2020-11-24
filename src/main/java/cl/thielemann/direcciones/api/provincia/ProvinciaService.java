package cl.thielemann.direcciones.api.provincia;

import java.util.List;

public interface ProvinciaService {

    Provincia createOrUpdate(Provincia provincia);

    Provincia findById(Long id);

    List<Provincia> findAll();

    void deleteById(Long id);


}
