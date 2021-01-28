package cl.thielemann.direcciones.api.comuna.infrastructure;

import cl.thielemann.direcciones.api.comuna.domain.ComunaService;
import cl.thielemann.direcciones.api.comuna.domain.Comuna;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/comunas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComunaController {
    private ComunaService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comuna> create(@RequestBody Comuna comuna) {
        return new ResponseEntity<>(service.create(comuna), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comuna> update(@RequestBody Comuna comuna) {
        return new ResponseEntity<>(service.update(comuna), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comuna> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.findById(id), new HttpHeaders(), HttpStatus.FOUND);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comuna>> findAll() {
        return new ResponseEntity<>(service.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/provincias/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comuna>> findAllByProvincia(@PathVariable UUID id) {
        return new ResponseEntity<>(service.findAllByProvincia_id(id), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

}
