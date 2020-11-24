package cl.thielemann.direcciones.api.comuna;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComunaServiceImpl implements ComunaService {
    private ComunaRepository repository;

    @Override
    public Comuna createOrUpdate(Comuna comuna) {
        Optional<Comuna> optional = repository.findById(comuna.getId());
        if (optional.isPresent()) {
            Comuna updatable = optional.get();
            updatable.setName(comuna.getName());
            updatable.setProvincia(comuna.getProvincia());
            updatable.setStatus(comuna.getStatus());
            return repository.save(updatable);
        }
        return repository.save(comuna);
    }

    @Override
    public Comuna findById(Long id) {
        Optional<Comuna> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("Comuna not found.");
    }

    @Override
    public List<Comuna> findAll() {
        List<Comuna> comunas = repository.findAll();
        if (!comunas.isEmpty()) {
            return comunas;
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
