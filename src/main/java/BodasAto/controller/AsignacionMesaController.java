package BodasAto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BodasAto.Service.AsignacionMesaService;
import BodasAto.dto.AsignacionMesaDTO;

@RestController
@RequestMapping("/api/asignaciones-mesa")
public class AsignacionMesaController {

    private final AsignacionMesaService asignacionMesaService;

    public AsignacionMesaController(AsignacionMesaService asignacionMesaService) {
        this.asignacionMesaService = asignacionMesaService;
    }

    @GetMapping
    public ResponseEntity<List<AsignacionMesaDTO>> getAll() {
        return ResponseEntity.ok(asignacionMesaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionMesaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(asignacionMesaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AsignacionMesaDTO> create(@RequestBody AsignacionMesaDTO dto) {
        AsignacionMesaDTO created = asignacionMesaService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionMesaDTO> update(@PathVariable Integer id, @RequestBody AsignacionMesaDTO dto) {
        AsignacionMesaDTO updated = asignacionMesaService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        asignacionMesaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
