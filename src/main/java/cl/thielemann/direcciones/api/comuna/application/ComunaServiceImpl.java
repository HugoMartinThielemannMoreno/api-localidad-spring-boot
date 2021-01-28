package cl.thielemann.direcciones.api.comuna.application;

import cl.thielemann.direcciones.api.comuna.domain.Comuna;
import cl.thielemann.direcciones.api.comuna.domain.ComunaRepository;
import cl.thielemann.direcciones.api.comuna.domain.ComunaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author hmtm
 * Probando el javadoc
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComunaServiceImpl implements ComunaService {
    private ComunaRepository repository;

    @Override
    public Comuna create(Comuna comuna) {
        return repository.save(comuna);
    }

    @Override
    public Comuna update(Comuna comuna) {
        Optional<Comuna> optional = repository.findById(comuna.getId());
        if (optional.isPresent()) {
            Comuna updatable = optional.get();
            updatable.setName(comuna.getName());
            updatable.setProvincia(comuna.getProvincia());
            updatable.setStatus(comuna.getStatus());
            return repository.save(updatable);
        }
        throw new RuntimeException("Comuna no existe.");
    }

    @Transactional(readOnly = true)
    @Override
    public Comuna findById(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comuna> findAll() {
        List<Comuna> comunas = repository.findAll();
        if (!comunas.isEmpty()) {
            return comunas;
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comuna> findAllByProvincia_id(UUID id){
        List<Comuna> comunas = repository.findAllByProvincia_id(id);
        if (!comunas.isEmpty()) {
            return comunas;
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
