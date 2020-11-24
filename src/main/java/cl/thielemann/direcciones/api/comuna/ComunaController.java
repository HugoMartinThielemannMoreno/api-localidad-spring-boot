package cl.thielemann.direcciones.api.comuna;

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

@RestController
@RequestMapping(path = "/comunas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ComunaController {
    private ComunaServiceImpl service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comuna> createOrUpdate(@RequestBody Comuna comuna) {
        return new ResponseEntity<>(service.createOrUpdate(comuna), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comuna> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), new HttpHeaders(), HttpStatus.FOUND);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comuna>> findAll() {
        return new ResponseEntity<>(service.findAll(), new HttpHeaders(), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return HttpStatus.FORBIDDEN;
    }

}
