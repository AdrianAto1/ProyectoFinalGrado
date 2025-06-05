package BodasAto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import BodasAto.Service.InvitadoService;
import BodasAto.dto.InvitadoDTO;

@RestController
@RequestMapping("/api/invitados")
public class InvitadoController {

    @Autowired
    private InvitadoService invitadoService;

    @GetMapping
    public List<InvitadoDTO> getAllInvitados() {
        return invitadoService.getAllInvitados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvitadoDTO> getInvitadoById(@PathVariable Long id) {
        Optional<InvitadoDTO> invitadoOpt = invitadoService.getInvitadoById(id);
        return invitadoOpt.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/boda/{idBoda}")
    public List<InvitadoDTO> getInvitadosByBoda(@PathVariable Long idBoda) {
        return invitadoService.getInvitadosByIdBoda(idBoda);
    }

    @PostMapping
    public ResponseEntity<InvitadoDTO> createInvitado(@RequestBody InvitadoDTO invitadoDTO) {
        InvitadoDTO savedInvitado = invitadoService.saveInvitado(invitadoDTO);
        return ResponseEntity.ok(savedInvitado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvitadoDTO> updateInvitado(@PathVariable Long id, @RequestBody InvitadoDTO invitadoDTO) {
        Optional<InvitadoDTO> updatedInvitado = invitadoService.updateInvitado(id, invitadoDTO);
        return updatedInvitado.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitado(@PathVariable Long id) {
        boolean deleted = invitadoService.deleteInvitado(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/confirmacion")
    public ResponseEntity<Void> actualizarConfirmacion(@PathVariable Long id, @RequestParam boolean confirmado) {
        boolean updated = invitadoService.actualizarConfirmacion(id, confirmado);
        if (updated) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
