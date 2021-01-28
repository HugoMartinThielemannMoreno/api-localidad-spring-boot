package cl.thielemann.direcciones.api.region.application;

import cl.thielemann.direcciones.api.region.domain.Region;
import cl.thielemann.direcciones.api.region.domain.RegionRepository;
import cl.thielemann.direcciones.api.region.domain.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegionServiceImpl implements RegionService {
    private RegionRepository repository;

    @Override
    public Region createOrUpdate(Region region) {
        Optional<Region> optional = repository.findById(region.getUuid());
        if (optional.isPresent()) {
            Region updatable = optional.get();
            updatable.setName(region.getName());
            updatable.setProvincias(region.getProvincias());
            updatable.setStatus(region.getStatus());
            return repository.save(updatable);
        }
        return repository.save(region);
    }

    @Override
    public Region findById(UUID uuid) {
        Optional<Region> optional = repository.findById(uuid);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("Region not found.");
    }

    @Override
    public List<Region> findAll() {
        List<Region> regiones = repository.findAll();
        if (!regiones.isEmpty()) {
            return regiones;
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
