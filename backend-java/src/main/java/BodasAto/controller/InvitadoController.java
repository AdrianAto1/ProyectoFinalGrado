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

    // Obtener todos los invitados
    @GetMapping
    public List<InvitadoDTO> getAllInvitados() {
        return invitadoService.getAllInvitados();
    }

    // Obtener invitado por ID
    @GetMapping("/{id}")
    public ResponseEntity<InvitadoDTO> getInvitadoById(@PathVariable Long id) {
        Optional<InvitadoDTO> invitadoOpt = invitadoService.getInvitadoById(id);
        return invitadoOpt.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    //Invitados por boda
    @GetMapping("/boda/{idBoda}")
    public List<InvitadoDTO> getInvitadosByBoda(@PathVariable Long idBoda) {
        return invitadoService.getInvitadosByIdBoda(idBoda);
    }

    // Crear nuevo invitado
    @PostMapping
    public ResponseEntity<InvitadoDTO> createInvitado(@RequestBody InvitadoDTO invitadoDTO) {
        InvitadoDTO savedInvitado = invitadoService.saveInvitado(invitadoDTO);
        return ResponseEntity.ok(savedInvitado);
    }

    // Actualizar invitado existente
    @PutMapping("/{id}")
    public ResponseEntity<InvitadoDTO> updateInvitado(@PathVariable Long id, @RequestBody InvitadoDTO invitadoDTO) {
        Optional<InvitadoDTO> updatedInvitado = invitadoService.updateInvitado(id, invitadoDTO);
        return updatedInvitado.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar invitado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitado(@PathVariable Long id) {
        boolean deleted = invitadoService.deleteInvitado(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para actualizar solo confirmación (boolean)
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
