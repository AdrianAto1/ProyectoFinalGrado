package BodasAto.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import BodasAto.dto.AlergiaDTO;
import BodasAto.entity.Alergia;
import BodasAto.entity.Invitado;
import BodasAto.repository.AlergiaRepository;
import BodasAto.repository.InvitadoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlergiaService {

    private final AlergiaRepository alergiaRepository;
    private final InvitadoRepository invitadoRepository;

    public AlergiaService(AlergiaRepository alergiaRepository, InvitadoRepository invitadoRepository) {
        this.alergiaRepository = alergiaRepository;
        this.invitadoRepository = invitadoRepository;
    }

    private AlergiaDTO toDTO(Alergia alergia) {
        return new AlergiaDTO(
            alergia.getIdAlergia(),
            alergia.getNombre(),
            alergia.getInvitados() != null ?
                alergia.getInvitados().stream().map(Invitado::getIdInvitado).collect(Collectors.toList()) :
                null
        );
    }

    private Alergia toEntity(AlergiaDTO dto) {
        Alergia alergia = new Alergia();
        alergia.setIdAlergia(dto.getIdAlergia());
        alergia.setNombre(dto.getNombre());

        if (dto.getInvitadosIds() != null) {
            List<Invitado> invitados = dto.getInvitadosIds().stream()
                .map(id -> invitadoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + id)))
                .collect(Collectors.toList());
            alergia.setInvitados(invitados);
        }

        return alergia;
    }

    public List<AlergiaDTO> findAll() {
        return alergiaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public AlergiaDTO findById(Integer id) {
        Alergia alergia = alergiaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Alergia no encontrada con id " + id));
        return toDTO(alergia);
    }

    public AlergiaDTO create(AlergiaDTO dto) {
        Alergia alergia = toEntity(dto);
        return toDTO(alergiaRepository.save(alergia));
    }

    public AlergiaDTO update(Integer id, AlergiaDTO dto) {
        Alergia alergia = alergiaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Alergia no encontrada con id " + id));

        alergia.setNombre(dto.getNombre());

        if (dto.getInvitadosIds() != null) {
            List<Invitado> invitados = dto.getInvitadosIds().stream()
                .map(invId -> invitadoRepository.findById(invId)
                    .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + invId)))
                .collect(Collectors.toList());
            alergia.setInvitados(invitados);
        }

        return toDTO(alergiaRepository.save(alergia));
    }

    public void delete(Integer id) {
        if (!alergiaRepository.existsById(id)) {
            throw new EntityNotFoundException("Alergia no encontrada con id " + id);
        }
        alergiaRepository.deleteById(id);
    }
}
