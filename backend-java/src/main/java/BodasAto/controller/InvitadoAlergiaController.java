package BodasAto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BodasAto.dto.InvitadoAlergiaDTO;
import BodasAto.Service.InvitadoAlergiaService;

@RestController
@RequestMapping("/api/invitado-alergia")
public class InvitadoAlergiaController {

    private final InvitadoAlergiaService service;

    public InvitadoAlergiaController(InvitadoAlergiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<InvitadoAlergiaDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<InvitadoAlergiaDTO> create(@RequestBody InvitadoAlergiaDTO dto) {
        InvitadoAlergiaDTO created = service.create(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{idInvitado}/{idAlergia}")
    public ResponseEntity<Void> delete(@PathVariable Long idInvitado, @PathVariable Integer idAlergia) {
        service.delete(idInvitado, idAlergia);
        return ResponseEntity.noContent().build();
    }
}
