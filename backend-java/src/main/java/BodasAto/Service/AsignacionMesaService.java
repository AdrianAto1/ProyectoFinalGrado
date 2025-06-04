package BodasAto.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import BodasAto.dto.AsignacionMesaDTO;
import BodasAto.entity.AsignacionMesa;
import BodasAto.entity.Invitado;
import BodasAto.entity.Mesa;
import BodasAto.repository.AsignacionMesaRepository;
import BodasAto.repository.InvitadoRepository;
import BodasAto.repository.MesaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AsignacionMesaService {

    private final AsignacionMesaRepository asignacionMesaRepository;
    private final MesaRepository mesaRepository;
    private final InvitadoRepository invitadoRepository;

    public AsignacionMesaService(AsignacionMesaRepository asignacionMesaRepository,
                                MesaRepository mesaRepository,
                                InvitadoRepository invitadoRepository) {
        this.asignacionMesaRepository = asignacionMesaRepository;
        this.mesaRepository = mesaRepository;
        this.invitadoRepository = invitadoRepository;
    }

    private AsignacionMesaDTO toDTO(AsignacionMesa entity) {
        return new AsignacionMesaDTO(
            entity.getIdAsignacionMesa(),
            entity.getMesa() != null ? entity.getMesa().getIdMesa() : null,
            entity.getInvitado() != null ? entity.getInvitado().getIdInvitado() : null
        );
    }

    private AsignacionMesa toEntity(AsignacionMesaDTO dto) {
        AsignacionMesa entity = new AsignacionMesa();
        entity.setIdAsignacionMesa(dto.getIdAsignacionMesa());

        if (dto.getIdMesa() != null) {
            Mesa mesa = mesaRepository.findById(dto.getIdMesa())
                .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con id " + dto.getIdMesa()));
            entity.setMesa(mesa);
        }

        if (dto.getIdInvitado() != null) {
            Invitado invitado = invitadoRepository.findById(dto.getIdInvitado())
                .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + dto.getIdInvitado()));
            entity.setInvitado(invitado);
        }

        return entity;
    }

    public List<AsignacionMesaDTO> findAll() {
        return asignacionMesaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AsignacionMesaDTO findById(Integer id) {
        AsignacionMesa entity = asignacionMesaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("AsignacionMesa no encontrada con id " + id));
        return toDTO(entity);
    }

    public AsignacionMesaDTO create(AsignacionMesaDTO dto) {
        AsignacionMesa entity = toEntity(dto);
        entity = asignacionMesaRepository.save(entity);
        return toDTO(entity);
    }

    public AsignacionMesaDTO update(Integer id, AsignacionMesaDTO dto) {
        AsignacionMesa existing = asignacionMesaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("AsignacionMesa no encontrada con id " + id));

        if (dto.getIdMesa() != null) {
            Mesa mesa = mesaRepository.findById(dto.getIdMesa())
                .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con id " + dto.getIdMesa()));
            existing.setMesa(mesa);
        }

        if (dto.getIdInvitado() != null) {
            Invitado invitado = invitadoRepository.findById(dto.getIdInvitado())
                .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + dto.getIdInvitado()));
            existing.setInvitado(invitado);
        }

        existing = asignacionMesaRepository.save(existing);
        return toDTO(existing);
    }

    public void delete(Integer id) {
        if (!asignacionMesaRepository.existsById(id)) {
            throw new EntityNotFoundException("AsignacionMesa no encontrada con id " + id);
        }
        asignacionMesaRepository.deleteById(id);
    }
}
