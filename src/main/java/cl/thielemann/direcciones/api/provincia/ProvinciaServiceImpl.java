package cl.thielemann.direcciones.api.provincia;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProvinciaServiceImpl implements ProvinciaService {
    private ProvinciaRepository repository;

    @Override
    public Provincia createOrUpdate(Provincia provincia) {
        Optional<Provincia> optional = repository.findById(provincia.getId());
        if (optional.isPresent()) {
            Provincia updatable = optional.get();
            updatable.setName(provincia.getName());
            updatable.setRegion(provincia.getRegion());
            updatable.setComunas(provincia.getComunas());
            updatable.setStatus(provincia.getStatus());
            return repository.save(updatable);
        }
        return repository.save(provincia);
    }

    @Override
    public Provincia findById(Long id) {
        Optional<Provincia> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("Provincia not found.");
    }

    @Override
    public List<Provincia> findAll() {
        List<Provincia> provincias = repository.findAll();
        if (!provincias.isEmpty()) {
            return provincias;
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
