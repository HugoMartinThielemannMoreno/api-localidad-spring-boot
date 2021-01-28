package cl.thielemann.direcciones.api.region.infrastructure;

import cl.thielemann.direcciones.api.region.domain.Region;
import cl.thielemann.direcciones.api.region.application.RegionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/regiones")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegionController {
    private RegionServiceImpl service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Region> createOrUpdate(@Valid @RequestBody Region region) {
        return new ResponseEntity<>(service.createOrUpdate(region), new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Region> findById(@PathVariable UUID uuid) {
        return new ResponseEntity<>(service.findById(uuid), new HttpHeaders(), HttpStatus.FOUND);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Region>> findAll() {
        return new ResponseEntity<>(service.findAll(), new HttpHeaders(), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{uuid}")
    public HttpStatus deleteById(@PathVariable UUID uuid) {
        service.deleteById(uuid);
        return HttpStatus.FORBIDDEN;
    }
}
