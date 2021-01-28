package cl.thielemann.direcciones.api.region.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface RegionRepository extends JpaRepository<Region, UUID> {
@Query(value = "select name from Region ", nativeQuery = true)
    List<Region> findAllOnlyName();
}
