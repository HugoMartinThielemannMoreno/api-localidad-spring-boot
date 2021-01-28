package cl.thielemann.direcciones.api.region.domain;

import java.util.List;
import java.util.UUID;

public interface RegionService {

    Region createOrUpdate(Region region);

    Region findById(UUID uuid);

    List<Region> findAll();

    void deleteById(UUID uuid);

}
