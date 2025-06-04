package BodasAto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BodasAto.dto.BodaDTO;
import BodasAto.Service.BodaService;

@RestController
@RequestMapping("/api/bodas")
public class BodaController {

    private final BodaService bodaService;

    public BodaController(BodaService bodaService) {
        this.bodaService = bodaService;
    }

    @GetMapping
    public ResponseEntity<List<BodaDTO>> getAll() {
        return ResponseEntity.ok(bodaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bodaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BodaDTO> create(@RequestBody BodaDTO dto) {
        BodaDTO created = bodaService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodaDTO> update(@PathVariable Long id, @RequestBody BodaDTO bodaDTO) {
        BodaDTO updated = bodaService.update(id, bodaDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bodaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
