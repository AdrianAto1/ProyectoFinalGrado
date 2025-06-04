package BodasAto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BodasAto.dto.TipoPlatoDTO;
import BodasAto.Service.TipoPlatoService;

@RestController
@RequestMapping("/api/tiposplato")
public class TipoPlatoController {

    @Autowired
    private TipoPlatoService tipoPlatoService;

    @PostMapping
    public ResponseEntity<TipoPlatoDTO> createTipoPlato(@RequestBody TipoPlatoDTO dto) {
        TipoPlatoDTO created = tipoPlatoService.saveTipoPlato(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<TipoPlatoDTO>> getAllTipos() {
        List<TipoPlatoDTO> tipos = tipoPlatoService.getAllTipos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPlatoDTO> getTipoById(@PathVariable Integer id) {
        Optional<TipoPlatoDTO> tipoOpt = tipoPlatoService.getTipoById(id);
        return tipoOpt.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPlatoDTO> updateTipoPlato(@PathVariable Integer id, @RequestBody TipoPlatoDTO dto) {
        try {
            TipoPlatoDTO updated = tipoPlatoService.updateTipoPlato(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPlato(@PathVariable Integer id) {
        if (tipoPlatoService.deleteTipoPlato(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
