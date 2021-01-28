package cl.thielemann.direcciones.api.provincia.application;

import cl.thielemann.direcciones.api.provincia.domain.Provincia;
import cl.thielemann.direcciones.api.provincia.domain.ProvinciaRepository;
import cl.thielemann.direcciones.api.provincia.domain.ProvinciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProvinciaServiceImpl implements ProvinciaService {
    private ProvinciaRepository repository;

    @Override
    public Provincia createOrUpdate(Provincia provincia) {
        Optional<Provincia> optional = repository.findById(provincia.getUuid());
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
    public Provincia findById(UUID uuid) {
        Optional<Provincia> optional = repository.findById(uuid);
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
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
