package BodasAto.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BodasAto.dto.MesaDTO;
import BodasAto.entity.Boda;
import BodasAto.entity.Invitado;
import BodasAto.entity.Mesa;
import BodasAto.repository.BodaRepository;
import BodasAto.repository.InvitadoRepository;
import BodasAto.repository.MesaRepository;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private BodaRepository bodaRepository;

    @Autowired
    private InvitadoRepository invitadoRepository;

    public MesaDTO saveMesa(MesaDTO dto) {
        Mesa mesa = new Mesa();
        if (dto.getIdMesa() != null) {
            mesa.setIdMesa(dto.getIdMesa());
        }
        mesa.setNumeroMesa(dto.getNumeroMesa());

        Optional<Boda> bodaOpt = bodaRepository.findById(dto.getIdBoda());
        if (bodaOpt.isEmpty()) {
            throw new RuntimeException("Boda no encontrada con id: " + dto.getIdBoda());
        }
        mesa.setBoda(bodaOpt.get());

        if (dto.getIdInvitados() != null && !dto.getIdInvitados().isEmpty()) {
            List<Invitado> invitados = invitadoRepository.findAllById(dto.getIdInvitados());
            mesa.setInvitados(invitados);
        }

        Mesa savedMesa = mesaRepository.save(mesa);

        return mapToDTO(savedMesa);
    }

    public List<MesaDTO> getAllMesas() {
        return mesaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<MesaDTO> getMesaById(Long id) {
        return mesaRepository.findById(id).map(this::mapToDTO);
    }

    public MesaDTO updateMesa(Long id, MesaDTO dto) {
        Optional<Mesa> mesaOpt = mesaRepository.findById(id);
        if (mesaOpt.isEmpty()) {
            throw new RuntimeException("Mesa no encontrada con id: " + id);
        }
        Mesa mesa = mesaOpt.get();
        mesa.setNumeroMesa(dto.getNumeroMesa());

        Optional<Boda> bodaOpt = bodaRepository.findById(dto.getIdBoda());
        if (bodaOpt.isEmpty()) {
            throw new RuntimeException("Boda no encontrada con id: " + dto.getIdBoda());
        }
        mesa.setBoda(bodaOpt.get());

        if (dto.getIdInvitados() != null) {
            List<Invitado> invitados = invitadoRepository.findAllById(dto.getIdInvitados());
            mesa.setInvitados(invitados);
        }

        Mesa updatedMesa = mesaRepository.save(mesa);
        return mapToDTO(updatedMesa);
    }

    public boolean deleteMesa(Long id) {
        if (mesaRepository.existsById(id)) {
            mesaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private MesaDTO mapToDTO(Mesa mesa) {
        List<Long> idInvitados = null;
        if (mesa.getInvitados() != null) {
            idInvitados = mesa.getInvitados().stream()
                    .map(Invitado::getIdInvitado)
                    .collect(Collectors.toList());
        }
        return new MesaDTO(
                mesa.getIdMesa(),
                mesa.getNumeroMesa(),
                mesa.getBoda() != null ? mesa.getBoda().getIdBoda() : null,
                idInvitados
        );
    }
}
