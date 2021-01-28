package cl.thielemann.direcciones.api.comuna.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, UUID> {
    List<Comuna> findAllByProvincia_id(UUID id);
}
