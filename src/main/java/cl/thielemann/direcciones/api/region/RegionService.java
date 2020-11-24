package cl.thielemann.direcciones.api.region;

import java.util.List;

public interface RegionService {

    Region createOrUpdate(Region region);

    Region findById(Long id);

    List<Region> findAll();

    void deleteById(Long id);

}
