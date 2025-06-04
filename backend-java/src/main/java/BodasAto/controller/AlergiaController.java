package BodasAto.controller;

import BodasAto.Service.AlergiaService;
import BodasAto.dto.AlergiaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alergias")
public class AlergiaController {

    private final AlergiaService alergiaService;

    public AlergiaController(AlergiaService alergiaService) {
        this.alergiaService = alergiaService;
    }

    @GetMapping
    public List<AlergiaDTO> getAllAlergias() {
        return alergiaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlergiaDTO> getAlergiaById(@PathVariable Integer id) {
        return ResponseEntity.ok(alergiaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlergiaDTO> createAlergia(@RequestBody AlergiaDTO dto) {
        return ResponseEntity.ok(alergiaService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlergiaDTO> updateAlergia(@PathVariable Integer id, @RequestBody AlergiaDTO dto) {
        return ResponseEntity.ok(alergiaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlergia(@PathVariable Integer id) {
        alergiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
