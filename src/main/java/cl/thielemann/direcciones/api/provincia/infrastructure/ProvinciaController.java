package cl.thielemann.direcciones.api.provincia.infrastructure;

import cl.thielemann.direcciones.api.provincia.domain.Provincia;
import cl.thielemann.direcciones.api.provincia.application.ProvinciaServiceImpl;
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

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/provincias")
public class ProvinciaController {
    private ProvinciaServiceImpl service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Provincia> createOrUpdate(@RequestBody Provincia provincia) {
        return new ResponseEntity<>(service.createOrUpdate(provincia), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Provincia> findById(@PathVariable UUID uuid) {
        return new ResponseEntity<>(service.findById(uuid), new HttpHeaders(), HttpStatus.FOUND);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Provincia>> findAll() {
        return new ResponseEntity<>(service.findAll(), new HttpHeaders(), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{uuid}")
    public HttpStatus deleteById(@PathVariable UUID uuid) {
        service.deleteById(uuid);
        return HttpStatus.FORBIDDEN;
    }
}
